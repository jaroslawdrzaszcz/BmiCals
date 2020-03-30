package com.example.bmicalculator.Activites;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.R;

public class Covid19DietActivity extends AppCompatActivity {

    Button showDiet;
    Button back;
    Button bmiCalcButton;
    TextView bmi;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_diet);

        showDiet = findViewById(R.id.covid19_diet_calc);
        back = findViewById(R.id.covid19_back);
        bmiCalcButton = findViewById(R.id.diet_bmi_calc);

        showDiet.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v) {
                showResult();
            }
        });

        bmiCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lauchBmiActivity();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void lauchBmiActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showResult(){
        bmi = findViewById(R.id.covid19_bmi);
        description = findViewById(R.id.your_diet);
        String bmiString = bmi.getText().toString();
        Log.i("Bmi string:%s", bmiString);

        String descriptionText = "";
        AlertDialog alert = new AlertDialog.Builder(Covid19DietActivity.this).create();

        if (bmiString.isEmpty()) {
            alert.setTitle("Msg:");
            alert.setMessage("Należy podać wartość BMI!");
            alert.setButton(AlertDialog.BUTTON_NEGATIVE, "ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int witch) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();
        } else{
            double bmiValue = Double.parseDouble(bmiString);
            if(bmiValue < 18.5){
                descriptionText = "Wódka, kapusta kiszona, ogórki kiszone i banany";
            }
            else if(bmiValue >= 18.5 && bmiValue < 25){
                descriptionText = "Wódka, kapusta kiszona, ogórki kiszone.";
            }
            else if(bmiValue >= 25 && bmiValue < 30){
                descriptionText = "Wódka, kapusta kiszona.";
            }
            else if(bmiValue >= 30){
                descriptionText = "Wódka.";
            }
        }
        description.setText(descriptionText);
    }
}
