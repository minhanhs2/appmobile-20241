package com.example.simplelist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etNumber = findViewById<EditText>(R.id.etNumber)
        val rbEven = findViewById<RadioButton>(R.id.rbEven)
        val rbOdd = findViewById<RadioButton>(R.id.rbOdd)
        val rbSquare = findViewById<RadioButton>(R.id.rbSquare)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val listView = findViewById<ListView>(R.id.listView)
        val tvError = findViewById<TextView>(R.id.tvError)

        btnShow.setOnClickListener {
            val input = etNumber.text.toString()

            if (input.isEmpty() || input.toIntOrNull() == null || input.toInt() <= 0) {
                tvError.text = "Please enter a valid positive integer."
                return@setOnClickListener
            }

            val n = input.toInt()
            val result = when {
                rbEven.isChecked -> getEvenNumbers(n)
                rbOdd.isChecked -> getOddNumbers(n)
                rbSquare.isChecked -> getSquareNumbers(n)
                else -> {
                    tvError.text = "Please select a number type."
                    return@setOnClickListener
                }
            }

            tvError.text = ""
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, result)
            listView.adapter = adapter
        }
    }

    private fun getEvenNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 == 0 }
    }

    private fun getOddNumbers(n: Int): List<Int> {
        return (0..n).filter { it % 2 != 0 }
    }

    private fun getSquareNumbers(n: Int): List<Int> {
        return (0..n).filter { isPerfectSquare(it) }
    }

    private fun isPerfectSquare(num: Int): Boolean {
        val sqrt = Math.sqrt(num.toDouble()).toInt()
        return sqrt * sqrt == num
    }
}