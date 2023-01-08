package com.example.smarthhome

import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class IrrigationActivity: AppCompatActivity() {

    private lateinit var button: ToggleButton
    lateinit var totalTime: EditText
    lateinit var remTime: TextView
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.irrigation_layout)
        val actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initViews()
        setButtonCheckListener()
    }

    private fun setButtonCheckListener() {
        button.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) {
                val minutes = TimeUnit.MINUTES.toMillis(totalTime.text.toString().toLong())
                timer = object : CountDownTimer(minutes, 1000) {
                    override fun onTick(p0: Long) {
                        remTime.text = TimeUnit.MILLISECONDS.toMinutes(p0).toString() +
                                " min " +
                                (TimeUnit.MILLISECONDS.toSeconds(p0) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(p0))).toString() +
                                " sec"
                    }
                    override fun onFinish() {
                        remTime.text = "0 min 0 sec"
                    }
                }
                timer.start()
            } else {
                timer.onFinish()
                timer.cancel()
            }
        }
    }

    private fun initViews() {
        button = findViewById(R.id.irrToggleButton)
        totalTime = findViewById(R.id.irrMinEditText)
        remTime = findViewById(R.id.irrRemTimeTextView)
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