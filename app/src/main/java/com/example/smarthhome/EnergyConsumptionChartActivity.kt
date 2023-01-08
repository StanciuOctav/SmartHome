package com.example.smarthhome

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.MPPointF
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random
class EnergyConsumptionChartActivity: AppCompatActivity()  {
    private lateinit var textViewChartTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.energy_consumption_chart_layout)
        var actionBar = supportActionBar


        val intent = intent
        val selectedDate = intent.getStringExtra("selectedDate")

        if (actionBar != null) {
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initializeView(selectedDate)
        initializeChart()
    }

    private fun initializeView(selectedDate:String?) {
        textViewChartTitle=findViewById(R.id.textViewSelectedDate)
        textViewChartTitle.text= "Energy consumption from $selectedDate"
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

    private fun initializeChart()
    {
        val pieChart = findViewById<PieChart>(R.id.pieChart)

// configure pie chart
        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        pieChart.dragDecelerationFrictionCoef = 0.95f

        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)

        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)

        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f

        pieChart.setDrawCenterText(true)

        pieChart.rotationAngle = 0f
        pieChart.isRotationEnabled = true

        pieChart.isHighlightPerTapEnabled = true

        // add data
        val entries = ArrayList<PieEntry>()
        var limit=1000
        var value=Random.nextInt(100,limit*100).toFloat()/100
        var total=value

        entries.add(PieEntry(value, "Water heating"))

        value=Random.nextInt(100,limit*100).toFloat()/100
        total+=value
        entries.add(PieEntry(value, "Lighting"))

        value=Random.nextInt(100,limit*100).toFloat()/100
        total+=value
        entries.add(PieEntry(value,"Space heating"))

        value=Random.nextInt(100,limit*100).toFloat()/100
        total+=value
        entries.add(PieEntry(value, "Electronics"))

        value=Random.nextInt(100,limit*100).toFloat()/100
        total+=value
        entries.add(PieEntry(value, "Appliances"))

        val dataSet = PieDataSet(entries, "Consumption")
        dataSet.setDrawIcons(true)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        pieChart.centerText= "Total consumption:\n$total wH"
        pieChart.setCenterTextSize(18f)
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleColor(Color.parseColor("#EEEDDE"))


        // add colors
        val colors = ArrayList<Int>()
        colors.add(Color.rgb(27, 82, 4))
        colors.add(Color.rgb(226, 68, 98))
        colors.add(Color.rgb(252, 186, 3))
        colors.add(Color.rgb(70, 126, 128))
        colors.add(Color.rgb(116, 123, 179))
        colors.add(Color.rgb(179, 116, 170))
        colors.add(Color.rgb(168, 179, 116))

        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return String.format("%.2f wH", value)
            }
        })
        data.setValueTextSize(22f)
        data.setValueTextColor(Color.BLACK)
        pieChart.data = data

        pieChart.invalidate()
    }

}