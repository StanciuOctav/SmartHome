package com.example.smarthhome

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DoorActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_door_layout)
        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        clickedCardView()
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
    private fun clickedCardView() {
        findViewById<CardView>(R.id.frontDoorCard).setOnClickListener {
            val intent = Intent(this@DoorActivity, DoorDetailsActivity::class.java)
            intent.putExtra("door_layout", R.layout.front_door_details_layout);
            intent.putExtra("door_title", "Front Door");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.backDoorCard).setOnClickListener {
            val intent = Intent(this@DoorActivity, DoorDetailsActivity::class.java)
            intent.putExtra("door_layout", R.layout.back_door_details_layout);
            intent.putExtra("door_title", "Back Door");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.bedroomDoorCard).setOnClickListener {
            val intent = Intent(this@DoorActivity, DoorDetailsActivity::class.java)
            intent.putExtra("door_layout", R.layout.bedroom_door_details_layout);
            intent.putExtra("door_title", "Bedroom Door");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.balconyDoorCard).setOnClickListener {
            val intent = Intent(this@DoorActivity, DoorDetailsActivity::class.java)
            intent.putExtra("door_layout", R.layout.balcony_door_details_layout);
            intent.putExtra("door_title", "Balcony Door");
            startActivity(intent)
        }
    }
}