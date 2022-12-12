package com.example.smarthhome

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.front_door_details_layout.*



class DoorDetailsActivity: AppCompatActivity()  {
    private lateinit var textViewChosenDoor: TextView

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
               // main.setBackgroundColor(Color.DKGRAY)
                switchLockDoor.setTextColor(Color.WHITE)
                switchLockDoor.text="Locked"
            }
            else{
                //main.setBackgroundColor(Color.WHITE)
                switchLockDoor.setTextColor(Color.BLACK)
                switchLockDoor.text="Unlocked"
            }
        }
    }

    private fun initializeView(doorTitle:String?) {
        textViewChosenDoor=findViewById(R.id.textViewChosenDoorTitle)
        textViewChosenDoor.text=doorTitle
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