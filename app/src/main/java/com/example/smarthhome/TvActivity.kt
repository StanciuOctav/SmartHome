package com.example.smarthhome

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class TvActivity: AppCompatActivity()  {
    private var isTvOn:Boolean = false
    private var channelNumber:Int = 0
    private var volumeNumber:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tv_layout)
        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
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

    fun powerClick(view: View){
        var isOn=""
        isTvOn=!isTvOn

        isOn = if(isTvOn)
            "ON"
        else
            "OFF"

        val text = "Your TV is $isOn"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun previousClick(view:View){
        channelNumber--
        if(channelNumber<1)
            channelNumber=255
        val text = "Channel changed to $channelNumber"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun nextClick(view:View){
        channelNumber++
        if(channelNumber>255)
            channelNumber=1
        val text = "Channel changed to $channelNumber"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun turnDownClick(view:View){
        volumeNumber--
        if(volumeNumber<1)
            volumeNumber=0
        val text = "Volume turned down to $volumeNumber"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun turnUpClick(view:View){
        volumeNumber++
        if(volumeNumber>40)
            volumeNumber=40
        val text = "Volume turned up to $volumeNumber"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun muteClick(view:View){
        val text = "TV muted"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

}