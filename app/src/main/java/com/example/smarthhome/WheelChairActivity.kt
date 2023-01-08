package com.example.smarthhome

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class WheelChairActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wheelchair_layout)
        // calling the action bar
        var actionBar = supportActionBar
        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setCustomView(R.layout.abs_layout);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //TO DO - set with logged username
        }

        clickedCardView()
    }

    // Override methods

    // add menu button to action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.abs_menu, menu);
        return true
    }

    // this event will enable the back function to the button on press
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    // Private methods

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun clickedCardView() {
        var switch1 = false
        var switch2 = false
        val switch = findViewById<Switch>(R.id.switchWheelchair1)
        findViewById<CardView>(R.id.wheelchairCard1).setOnClickListener {
            switch.setOnCheckedChangeListener { _, isChecked ->
                switch1 = isChecked
            }
            switch.visibility = View.VISIBLE
            switch.isChecked = switch1
            switch.text = "Front ramp"
        }

        findViewById<CardView>(R.id.wheelchairCard2).setOnClickListener {
            switch.setOnCheckedChangeListener { _, isChecked ->
                switch2 = isChecked
            }
            switch.visibility = View.VISIBLE
            switch.isChecked = switch2
            switch.text = "Back ramp"
        }
    }

    //handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}