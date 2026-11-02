package com.imthiyas.arapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var drillSpinner: Spinner
    private lateinit var viewDetailsBtn: Button
    private lateinit var startArBtn: Button
    private val drills = listOf(
        "Foundation Depth Drill",
        "GeoScan Borehole Drill",
        "Subsurface Probe Drill"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setArAdapter()



        viewDetailsBtn.setOnClickListener {
            val selectedDrill = drillSpinner.selectedItem.toString()
            val intent = Intent(this, DrillDetailsActivity::class.java)
            intent.putExtra("drill", selectedDrill)
            startActivity(intent)
        }

        startArBtn.setOnClickListener {
            val intent = Intent(this, ArDrillActivity::class.java)
            startActivity(intent)
        }

    }


    private fun initViews() {
        drillSpinner = findViewById(R.id.drillSpinner)
        viewDetailsBtn = findViewById(R.id.viewDetailsBtn)
        startArBtn = findViewById(R.id.startArBtn)
    }

    private fun setArAdapter() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, drills)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        drillSpinner.adapter = adapter
    }


}