package com.example.smarthhome

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class WindowActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_window_layout)
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
        findViewById<CardView>(R.id.frontWindowCard).setOnClickListener {
            val intent = Intent(this@WindowActivity, WindowDetailsActivity::class.java)
            intent.putExtra("window_layout", R.layout.front_window_details_layout);
            intent.putExtra("window_title", "Front Window");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.backWindowCard).setOnClickListener {
            val intent = Intent(this@WindowActivity, WindowDetailsActivity::class.java)
            intent.putExtra("window_layout", R.layout.back_window_details_layout);
            intent.putExtra("window_title", "Back Window");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.bedroomWindowCard).setOnClickListener {
            val intent = Intent(this@WindowActivity, WindowDetailsActivity::class.java)
            intent.putExtra("window_layout", R.layout.bedroom_window_details_layout);
            intent.putExtra("window_title", "Bedroom Window");
            startActivity(intent)
        }
        findViewById<CardView>(R.id.balconyWindowCard).setOnClickListener {
            val intent = Intent(this@WindowActivity, WindowDetailsActivity::class.java)
            intent.putExtra("window_layout", R.layout.balcony_window_details_layout);
            intent.putExtra("window_title", "Balcony Window");
            startActivity(intent)
        }
    }
}