package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculatorkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun btnClick(view: View) {
        if (newOperator) {
            binding.editTextView.setText("")
        }
        newOperator = false
        var btnChoosen = view as Button
        var clickedValueString: String = binding.editTextView.text.toString()

        when (btnChoosen.id) {
            binding.button0.id -> {
                clickedValueString += "0"
            }
            binding.button1.id -> {
                clickedValueString += "1"
            }
            binding.button2.id -> {
                clickedValueString += "2"
            }
            binding.button3.id -> {
                clickedValueString += "3"
            }
            binding.button4.id -> {
                clickedValueString += "4"
            }
            binding.button5.id -> {
                clickedValueString += "5"
            }
            binding.button6.id -> {
                clickedValueString += "6"
            }
            binding.button7.id -> {
                clickedValueString += "7"
            }
            binding.button8.id -> {
                clickedValueString += "8"
            }
            binding.button9.id -> {
                clickedValueString += "9"
            }
            binding.buttonPlusMinus.id -> {
                clickedValueString += "-" + clickedValueString
            }
        }
        binding.editTextView.setText(clickedValueString.toString())

    }

    var operator = "*"
    var previousValue = ""
    var newOperator = true

    fun btnOperatorClick(view: View) {
        var btnChoosen = view as Button
        when (btnChoosen.id) {
            binding.buttonPlus.id -> {
                operator = "+"
            }
            binding.buttonMinus.id -> {
                operator = "-"
            }
            binding.buttonMultiply.id -> {
                operator = "x"
            }
            binding.buttonDiv.id -> {
                operator = "/"
            }
        }
        previousValue = binding.editTextView.text.toString()
        newOperator = true
    }

    fun btnEquals(view: View) {
        var newValue = binding.editTextView.text.toString()
        var resultValue: Double? = null
        when (operator) {
            "/" -> {
                if (newValue.toDouble() == 0.0){
                    binding.editTextView.setText("Error")
                }
                resultValue = previousValue.toDouble() / newValue.toDouble()
            }
            "x" -> {
                resultValue = previousValue.toDouble() * newValue.toDouble()
            }
            "-" -> {
                resultValue = previousValue.toDouble() - newValue.toDouble()
            }
            "+" -> {
                resultValue = previousValue.toDouble() + newValue.toDouble()
            }
        }
        binding.editTextView.setText(resultValue.toString())
        newOperator = true
    }

    fun btnAc(view: View) {
        binding.editTextView.setText("0")
        newOperator = true
    }

    fun btnPercent(view: View) {
        var number: Double = binding.editTextView.text.toString().toDouble() / 100
        binding.editTextView.setText(number.toString())
        newOperator = true
    }
}