package com.example.bmicalculator.kotlin

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R
import kotlinx.android.synthetic.main.content_calorie_calc.*

@SuppressLint("Registered")
class CalorieCalcActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_calc)

        calorie_calc_back.setOnClickListener{
            finish()
        }

        calculate_calories.setOnClickListener{
            val value = calculate()
            showResult(value)
        }
    }

    private fun calculate(): Double
    {
        val highValue = calories_high.text.toString()
        val weightValue = calories_weight.text.toString()
        val ageValue = calories_age.text.toString()
        val genderGroup = gender
        val gender = genderGroup.checkedRadioButtonId

        var kCalcValue = 0.0
        val alert = AlertDialog.Builder(this@CalorieCalcActivity).create()

        if (highValue.isEmpty() || weightValue.isEmpty() || ageValue.isEmpty() || gender == -1) {
            alert.setTitle("Msg:")
            alert.setMessage("Należy podać wartości waga, wzrost, wiek i zaznaczyć płeć")
            alert.setButton(Dialog.BUTTON_NEGATIVE, "OK") {
                //do your own idea.
                _, _ -> finish() }
            alert.show()
        } else {
            if (gender == R.id.buttonMale) {
                kCalcValue = 66.47 + 13.7 * weightValue.toDouble() + 5.0 * highValue.toDouble() - 6.76 * ageValue.toDouble()
            } else if (gender == R.id.buttonFemale) {
                kCalcValue = 665.1 + 9.567 * weightValue.toDouble() + 1.85 * highValue.toDouble() - 4.68 * ageValue.toDouble()
            }
        }
        return kCalcValue
    }

    private fun showResult(kCalcValue: Double)
    {
        val roundKCalValue: Double = (((kCalcValue * 100).toInt()).toDouble()) / 100
        calories.setText(roundKCalValue.toString())
    }
}
