package com.example.smarthhome

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class LightsActivity: AppCompatActivity() {

    private lateinit var progressText: TextView
    private lateinit var progressBar: SeekBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lights_layout)
        // calling the action bar
        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setCustomView(R.layout.abs_layout)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        initViews()
    }

    private fun initViews() {
        progressText = findViewById(R.id.currentIntensityTextView)
        progressBar = findViewById(R.id.progressBar)
        progressBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                progressText.text = "Current Progress: " + p1 + "%"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                print("ceva")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                print("ceva2")
            }

        })
    }
}