package com.example.bmicalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calcuate;
    TextView high;
    TextView weight;
    TextView bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calcuate = findViewById(R.id.calculate);
        high = findViewById(R.id.high);
        weight = findViewById(R.id.weight);
        bmi = findViewById(R.id.bmi);

        calcuate.setOnClickListener(new View.OnClickListener (){
            public void onClick(View v) {
                final String highValue = high.getText().toString();
                final String weightValue = weight.getText().toString();

                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();

                if (highValue.isEmpty() || weightValue.isEmpty()) {
                    alert.setTitle("Msg:");
                    alert.setMessage("Należy podać wartość wiek i wzrost!");
                    alert.setButton(AlertDialog.BUTTON_NEGATIVE, "ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int witch) {
                            dialogInterface.dismiss();
                        }
                    });
                    alert.show();
                } else {
                    Float bmiValue = Float.parseFloat(weightValue) / (Float.parseFloat(highValue)*Float.parseFloat(highValue));
                    String bmiText = Float.toString(bmiValue);
                    bmi.setText(bmiText);
                }
            }
        });
    }
}
