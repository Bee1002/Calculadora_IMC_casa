package com.example.calculadoraimc

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var weigtEditText: EditText
    lateinit var heigtEditText: EditText
    lateinit var calculateButton: Button

    lateinit var  resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        weigtEditText = findViewById(R.id.weightEditText)
        heigtEditText = findViewById(R.id.heightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton.setOnClickListener {
            val weight = weigtEditText.text.toString().toFloat()
            val height = heigtEditText.text.toString().toFloat()
            val result = weight / (height / 100).pow(2)

            resultTextView.text = String.format("%.2f",result)

            println("Peso: $weight")
            println("Altura: $height")
            println("El IMC es: $result")
        }

    }
}