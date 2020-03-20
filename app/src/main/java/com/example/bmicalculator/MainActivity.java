package com.example.bmicalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    Button back;
    TextView high;
    TextView weight;
    TextView bmi;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calculate = findViewById(R.id.calculate);
        back = findViewById(R.id.bmi_back);

        calculate.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v) {
                double value = calculate();
                showResult(value);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private double calculate(){
        high = findViewById(R.id.high);
        weight = findViewById(R.id.weight);
        bmi = findViewById(R.id.bmi);
        description = findViewById(R.id.description);
        final String highValue = high.getText().toString();
        final String weightValue = weight.getText().toString();
        double bmiValue = 0;

        AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();

        if (highValue.isEmpty() || weightValue.isEmpty()) {
            alert.setTitle("Msg:");
            alert.setMessage("Należy podać wartość waga i wzrost!");
            alert.setButton(AlertDialog.BUTTON_NEGATIVE, "ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int witch) {
                    dialogInterface.dismiss();
                }
            });
            alert.show();
        } else {
            bmiValue = Double.parseDouble(weightValue) / (Double.parseDouble(highValue)*Double.parseDouble(highValue));
        }
        return bmiValue;
    }

    private void showResult(double bmiValue){
        double roundBmiValue = (double) Math.round(bmiValue * 100) /100;
        String bmiText = Double.toString(roundBmiValue);

        bmi.setText(bmiText);
        String descriptionText = "";
        if(bmiValue < 18.5){
            descriptionText = "Niedowaga";
        }
        else if(bmiValue >= 18.5 && bmiValue < 25){
            descriptionText = "W normie";
        }
        else if(bmiValue >= 25 && bmiValue < 30){
            descriptionText = "Nadwaga";
        }
        else if(bmiValue >= 30){
            descriptionText = "Otyłość";
        }
        description.setText(descriptionText);
    }
}
