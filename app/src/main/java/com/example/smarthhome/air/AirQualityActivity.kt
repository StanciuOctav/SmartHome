package com.example.smarthhome.air

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.smarthhome.LightsActivity
import com.example.smarthhome.R

class AirQualityActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.air_quality_rooms_layout)
        val actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        clickedCardView()
    }

    private fun clickedCardView() {
        // Here implement for all the cards
        findViewById<CardView>(R.id.airGroundFloorBathroomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Ground Floor Bathroom")
            startActivity(intent)
        }
        findViewById<CardView>(R.id.airLivingRoomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Living Room")
            startActivity(intent)
        }
        findViewById<CardView>(R.id.airKidsBedroomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Kids Bedroom")
            startActivity(intent)
        }
        findViewById<CardView>(R.id.airParentsBedroomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Parents Bedroom")
            startActivity(intent)
        }
        findViewById<CardView>(R.id.airParentBathroomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Parents Bathroom")
            startActivity(intent)
        }
        findViewById<CardView>(R.id.airUpstairsBathroomCard).setOnClickListener {
            val intent = Intent(this@AirQualityActivity, AirQualityDetailsActivity::class.java)
            intent.putExtra("RoomName", "Upstairs Bathroom")
            startActivity(intent)
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