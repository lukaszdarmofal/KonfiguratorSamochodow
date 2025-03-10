package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Radio buttons

        val cars_radiogroup = findViewById<RadioGroup>(R.id.car_radiogroup)
        val car_image = findViewById<ImageView>(R.id.car_image)
        var selectedCar = "Sedan"
        cars_radiogroup.setOnCheckedChangeListener {_, checkedId ->
            selectedCar = findViewById<RadioButton>(checkedId).text.toString()

            if (selectedCar == "Sedan") {
                car_image.setImageResource(R.drawable.sedan)
            } else if (selectedCar == "Suv") {
                car_image.setImageResource(R.drawable.carsuv)
            } else if (selectedCar == "Hatchback") {
                car_image.setImageResource(R.drawable.hatchback)
            }
        }

        // Checkboxy


        val attachment_1 = findViewById<CheckBox>(R.id.attachment_1)
        val attachment_2 = findViewById<CheckBox>(R.id.attachment_2)
        val attachment_3 = findViewById<CheckBox>(R.id.attachment_3)
        var att1 = false
        var att2 = false
        var att3 = false

        attachment_1.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) { att1 = true } else { att1 = false }
        }
        attachment_2.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) { att2 = true } else { att2 = false }
        }
        attachment_3.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked) { att3 = true } else { att3 = false }
        }

        // Button z podsumowaniem

        val summary_button = findViewById<Button>(R.id.summary_button)
        val summary_textview = findViewById<TextView>(R.id.summary_text)

        summary_button.setOnClickListener {
            val dodatki = mutableListOf<String>()
            if (att1) {dodatki.add("Klimatyzacja")}
            if (att2) {dodatki.add("Skórzane siedzenia")}
            if (att3) {dodatki.add("Android Auto")}
            if (dodatki.isEmpty()) { dodatki.add("brak") }

            dodatki.toString()

            summary_textview.text = "Wybrany samochód: ${selectedCar}\nWybrane dodatki: ${dodatki}"
        }




    }
}