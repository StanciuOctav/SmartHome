package com.example.smarthhome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class VacuumDetailsActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacuum_details_layout)
        // calling the action bar
        var actionBar = supportActionBar
        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setCustomView(R.layout.abs_layout);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //TO DO - set with logged username
            setUpButton()
        }
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

    private fun setUpButton() {
        val button = findViewById<Button>(R.id.saveButton)
        button.setOnClickListener {
            onBackPressed()
            Toast.makeText(baseContext, "Program set successfully", Toast.LENGTH_SHORT).show()
        }
    }

    //handle back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}