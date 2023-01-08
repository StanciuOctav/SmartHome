package com.example.smarthhome

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.front_door_details_layout.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DoorDetailsActivity: AppCompatActivity()  {
    private lateinit var textViewChosenDoor: TextView
    private lateinit var  linearLayoutOfChosenDoor:LinearLayout
    private lateinit var formatter: DateTimeFormatter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        // Get the layout resource ID that was passed as an extra
        val layoutId = intent.getIntExtra("door_layout", -1)
        // Set the activity's content view to the specified layout
        setContentView(layoutId)

        val doorTitle = intent.getStringExtra("door_title")

        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



       initializeView(doorTitle)
        switchLockDoor.setOnClickListener {
            if (switchLockDoor.isChecked){
                switchLockDoor.setTextColor(Color.WHITE)
                switchLockDoor.text="Locked"

                //add new notification
                val currentDate = LocalDateTime.now().format(formatter)
                val textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    text = "Door LOCKED at $currentDate"
                    height=70

                }
                linearLayoutOfChosenDoor.addView(textView)
            }
            else{
                switchLockDoor.setTextColor(Color.BLACK)
                switchLockDoor.text="Unlocked"

                //add new notification
                val currentDate = LocalDateTime.now().format(formatter)
                val textView = TextView(this).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    text = "Door UNLOCKED at $currentDate"
                    height=70

                }
                linearLayoutOfChosenDoor.addView(textView)

            }
        }
    }

    private fun initializeView(doorTitle:String?) {
        textViewChosenDoor=findViewById(R.id.textViewChosenDoorTitle)
        textViewChosenDoor.text=doorTitle
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")

        when (doorTitle) {
            "Front Door" -> linearLayoutOfChosenDoor=findViewById(R.id.layout_front_door);
            "Back Door" -> linearLayoutOfChosenDoor=findViewById(R.id.layout_back_door);
            "Balcony Door" -> linearLayoutOfChosenDoor=findViewById(R.id.layout_balcony_door);
            "Bedroom Door" -> linearLayoutOfChosenDoor=findViewById(R.id.layout_bedroom_door);

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
}