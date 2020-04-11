package com.example.bmicalculator.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.R;
import com.example.bmicalculator.kotlin.BmiCalc;
import com.example.bmicalculator.kotlin.CalorieCalcActivity;
import com.example.bmicalculator.kotlin.ChartsActivity;

public class StartActivity extends AppCompatActivity {

    Button bmiCalcButton;
    Button caloriesCalcButton;
    Button covid19DietButton;
    Button covid19QuizButton;
    Button covid19chartsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bmiCalcButton = findViewById(R.id.bmi_calc);
        caloriesCalcButton = findViewById(R.id.calorie_calc);
        covid19DietButton = findViewById(R.id.covid19_diet);
        covid19QuizButton = findViewById(R.id.covid19_quiz);
        covid19chartsButton = findViewById(R.id.covid19_chart);

        bmiCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchBmiActivity();
            }
        });

        caloriesCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchCaloriesActivity();
            }
        });

        covid19DietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchCovidDietActivity();
            }
        });

        covid19QuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchCovidQuizActivity();
            }
        });

        covid19chartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchCovidChartsActivity();
            }
        });
    }

    private void lauchBmiActivity() {
        Intent intent = new Intent(this, BmiCalc.class);
        startActivity(intent);
    }

    private void lauchCaloriesActivity() {
        Intent intent = new Intent(this, CalorieCalcActivity.class);
        startActivity(intent);
    }

    private void lauchCovidQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    private void lauchCovidChartsActivity() {
        Intent intent = new Intent(this, ChartsActivity.class);
        startActivity(intent);
    }

    private void lauchCovidDietActivity() {
        Intent intent = new Intent(this, Covid19DietActivity.class);
        startActivity(intent);
    }

}
