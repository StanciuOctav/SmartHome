package com.example.smarthhome

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.front_door_details_layout.*
import kotlinx.android.synthetic.main.front_window_details_layout.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class WindowDetailsActivity: AppCompatActivity()  {
    private lateinit var textViewChosenWindow: TextView
    private lateinit var  linearLayoutOfChosenWindow: LinearLayout
    private lateinit var formatter: DateTimeFormatter
    val hourFormat= SimpleDateFormat("HH:mm")
    private lateinit var toastMessage:Toast


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        // Get the layout resource ID that was passed as an extra
        val layoutId = intent.getIntExtra("window_layout", -1)
        // Set the activity's content view to the specified layout
        setContentView(layoutId)

        val windowTitle = intent.getStringExtra("window_title")

        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

       initializeView(windowTitle)

        switchLockWindow.setOnClickListener {
            if (switchLockWindow.isChecked){
                switchLockWindow.setTextColor(Color.WHITE)
                switchLockWindow.text="Locked"

                //add new notification
                val currentDate = LocalDateTime.now().format(formatter)
                val textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    text = "Window LOCKED at $currentDate"
                    height=70

                }
                linearLayoutOfChosenWindow.addView(textView)
            }
            else{
                switchLockWindow.setTextColor(Color.BLACK)
                switchLockWindow.text="Unlocked"

                //add new notification
                val currentDate = LocalDateTime.now().format(formatter)
                val textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    text = "Window UNLOCKED at $currentDate"
                    height=70

                }
                linearLayoutOfChosenWindow.addView(textView)

            }
        }
    }

    private fun initializeView(windowTitle:String?) {
        textViewChosenWindow=findViewById(R.id.textViewChosenWindowTitle)
        textViewChosenWindow.text=windowTitle
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")

        when (windowTitle) {
            "Front Window" -> linearLayoutOfChosenWindow=findViewById(R.id.layout_front_window);
            "Back Window" -> linearLayoutOfChosenWindow=findViewById(R.id.layout_back_window);
            "Balcony Window" -> linearLayoutOfChosenWindow=findViewById(R.id.layout_balcony_window);
            "Bedroom Window" -> linearLayoutOfChosenWindow=findViewById(R.id.layout_bedroom_window);

        }
    }

    // add menu button to action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.abs_menu, menu);
        return true
    }

    //handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setCurtainsClick(view: View) {

        try{
        val hourMorning=hourFormat.parse(editTextTimeMorning.text.toString())
            val hourEvening=hourFormat.parse(editTextTimeEvening.text.toString())

            Toast.makeText(applicationContext, "Your smart curtains has been set",
                Toast.LENGTH_SHORT).show()
        }
        catch (e:java.lang.Exception){
             toastMessage = Toast.makeText(applicationContext, "The hour does not have the correct format!",
                Toast.LENGTH_LONG)

            val text = view?.findViewById<TextView>(android.R.id.message)
            if (text != null) {
                text.setTextColor(Color.parseColor("#FF0000"))
            } //
            toastMessage.show()
        }

    }
}