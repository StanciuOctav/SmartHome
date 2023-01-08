package com.example.smarthhome

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.View
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.energy_consumption_layout.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class EnergyConsumptionActivity: AppCompatActivity()  {
    lateinit var currentDate: TextView
    lateinit var calendarView: CalendarView
    lateinit var ecoButton: ImageButton
    lateinit var selectedDate: String
    var ecoEnabled:Boolean =true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.energy_consumption_layout)
        var actionBar = supportActionBar

        if (actionBar != null) {
            // showing the back button and title in action bar
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        initializeViews()
    }

    private fun initializeViews(){
        currentDate = findViewById(R.id.idCurrentDate)
        calendarView = findViewById(R.id.calendarView)
        ecoButton = findViewById(R.id.imageButton)
        ecoButton.setBackgroundColor(Color.rgb(179, 167, 162))
        selectedDate=""

        calendarView
            .setOnDateChangeListener(

                CalendarView.OnDateChangeListener { _, year, month,dayOfMonth ->
                    var formattedDay=dayOfMonth.toString()
                    var formattedMonth=month.toString()

                    if(dayOfMonth<10)
                        formattedDay="0"+dayOfMonth
                    if(month<10)
                        formattedMonth="0"+(month+1)

                    selectedDate= (
                            formattedDay.toString() + "-"
                                    + (formattedMonth ) + "-" + year)
                    currentDate.text = selectedDate
                })
        calendarView.maxDate= Date().time
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

    fun viewClick(view: View) {
        try{

            val localDate = LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            val intent = Intent(this@EnergyConsumptionActivity, EnergyConsumptionChartActivity::class.java)
            intent.putExtra("selectedDate", selectedDate);
            startActivity(intent)
        }catch(e: java.lang.Exception){
            Toast.makeText(this@EnergyConsumptionActivity, "You must select a day!", Toast.LENGTH_SHORT).show()
        }

    }

    fun ecoClick(view:View){
        ecoEnabled=!ecoEnabled
        if(ecoEnabled){
            ecoButton.setBackgroundColor(Color.rgb(179, 167, 162))
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, "Eco mode disabled", duration)
            toast.show()

        }else {
            val progress = ProgressDialog(this)
            val handler = Handler()
            progress.setCancelable(false)

            progress.setTitle("Wait while activating the eco mode")

            progress.show()

            progress.setMessage("Setting the power mode for TV...")

            handler.postDelayed({
                progress.setMessage("Setting the power mode for lighting...")
            }, 1700)

            handler.postDelayed({
                progress.setMessage("Setting the power mode for surveillance cameras...")
            }, 3600)

            handler.postDelayed({
                progress.setMessage("Setting the power mode for thermostat...")
            }, 5300)

            handler.postDelayed({
                progress.setMessage("The ECO mode has been activated")
            }, 6500)

            handler.postDelayed({
                progress.dismiss()
            }, 8000)
            ecoButton.setBackgroundColor(Color.rgb(59, 143, 122))

        }
    }


}