package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button bmiCalcButton;
    Button caloriesCalcButton;
    Button covid19DietButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bmiCalcButton = findViewById(R.id.bmi_calc);
        caloriesCalcButton = findViewById(R.id.calorie_calc);
        covid19DietButton = findViewById(R.id.covid19_diet);

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
    }

    private void lauchBmiActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void lauchCaloriesActivity() {
        Intent intent = new Intent(this, CalorieCalcActivity.class);
        startActivity(intent);
    }

    private void lauchCovidDietActivity() {
        Intent intent = new Intent(this, Covid19DietActivity.class);
        startActivity(intent);
    }

}
