package com.example.bmicalculator.kotlin

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R
import kotlinx.android.synthetic.main.content_main.*

@SuppressLint("Registered")
class BmiCalc: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmi_back.setOnClickListener{
            finish()
        }

        calculate.setOnClickListener{
            val value = calculate()
            showResult(value)
        }
    }

    private fun calculate(): Double
    {
        val highValue = high.text.toString()
        val weightValue = weight.text.toString()

        var bmiValue = 0.0
        val alert = AlertDialog.Builder(this@BmiCalc).create()

        if (highValue.isEmpty() || weightValue.isEmpty()) {
            alert.setTitle("Msg:")
            alert.setMessage("Należy podać wartości wiek i wzrost!")
            alert.setButton(Dialog.BUTTON_NEGATIVE, "OK") {
                _, _ -> finish() }
            alert.show()
        } else {
            bmiValue = weightValue.toDouble() / (highValue.toDouble() * highValue.toDouble())
    }
        return bmiValue
    }

    private fun showResult(bmiValue: Double)
    {
        val roundBmiValue: Double = (((bmiValue * 100).toInt()).toDouble())/ 100
        bmi.setText(roundBmiValue.toString())
        var descriptionText = ""
        if (bmiValue < 18.5) {
            descriptionText = "Niedowaga"
        } else if (bmiValue >= 18.5 && bmiValue < 25) {
            descriptionText = "W normie"
        } else if (bmiValue >= 25 && bmiValue < 30) {
            descriptionText = "Nadwaga"
        } else if (bmiValue >= 30) {
            descriptionText = "Otyłość"
        }
        description.setText(descriptionText)
    }
}
