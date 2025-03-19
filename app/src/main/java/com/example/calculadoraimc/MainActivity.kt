package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Weight
    lateinit var removeWeightButton: Button
    lateinit var addWeightButton: Button
    lateinit var weightTextView: TextView
    //Height
    lateinit var heightSlider: Slider
    lateinit var heightTextView: TextView
//Result
    lateinit var calculateButton: Button
    lateinit var resultTextView: TextView

    var weight = 74.0f
    var height = 170.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        removeWeightButton = findViewById(R.id.removeWeightButton)
        addWeightButton = findViewById(R.id.addWeightButton)
        weightTextView = findViewById(R.id.weightTextView)
        heightSlider = findViewById(R.id.heightSlider)
        heightTextView = findViewById(R.id.heightTextView)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        removeWeightButton.setOnClickListener {
            weight --
            weightTextView.text = "${weight.toInt()} Kg"
        }
        addWeightButton.setOnClickListener {
            weight ++
            weightTextView.text = "${weight.toInt()} Kg"

        }
        heightSlider.addOnChangeListener { slider, value, fromUser ->
            height = value
            heightTextView.text = "${value.toInt()} cm"
        }
        calculateButton.setOnClickListener {
            var color = 0
            val result = weight / (height / 100).pow(2)

            resultTextView.text = String.format("%.2f",result)
            var colorId = 0
            var descriptionId = ""
            when(result) {
                in 0f..<18.5f -> {
                   colorId =  getColor(R.color.bmi_underweight)
                    descriptionId = getColor(R.color.bmi_underweight)

                }
                in 18.5f..<25f -> {
                   colorId =  getColor(R.color.bmi_normal_weight)
                    descriptionId = getColor(R.color.bmi_normal_weight)
                }
                in 25..<30 -> {
                   colorId =  getColor(R.color.bmi_overweight)
                    descriptionId = getColor(R.color.bmi_overweight)
                }
                in 30..<35 -> {
                   colorId =  getColor(R.color.bmi_obesity)
                    descriptionId = getColor(R.color.bmi_obesity)
                }
                else ->{
                    colorId = getColor(R.color.bmi_extreme_obesity)
                    descriptionId = getString(R.string.bmi_extreme_obesity)
                }
            }

descriptionTextView.text = descriptionId
descriptionTextView.setTextColor(colorId)
resultTextView.setTextColor(colorId)

        }

    }
}