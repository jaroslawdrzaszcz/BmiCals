//package com.example.bmicalculator.Activites;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.bmicalculator.R;
//
//public class CalorieCalcActivity extends AppCompatActivity {
//
//    Button calculate;
//    Button back;
//    TextView high;
//    TextView weight;
//    TextView age;
//    RadioGroup genderGroup;
//    TextView kCal;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calorie_calc);
//
//        calculate = findViewById(R.id.calculate_calories);
//        back = findViewById(R.id.calorie_calc_back);
//        kCal = findViewById(R.id.calories);
//
//        calculate.setOnClickListener(new View.OnClickListener (){
//            public void onClick(View v) {
//                double value = calculate();
//                showResult(value);
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
//
//    private double calculate(){
//        high = findViewById(R.id.calories_high);
//        weight = findViewById(R.id.calories_weight);
//        age = findViewById(R.id.calories_age);
//
//        final String highValue = high.getText().toString();
//        final String weightValue = weight.getText().toString();
//        final String ageValue = age.getText().toString();
//        genderGroup =  findViewById(R.id.gender);
//        int gender = genderGroup.getCheckedRadioButtonId();
//
//        double kCalcValue = 0;
//        AlertDialog alert = new AlertDialog.Builder(CalorieCalcActivity.this).create();
//
//        if (highValue.isEmpty() || weightValue.isEmpty() || ageValue.isEmpty() || gender == -1) {
//            alert.setTitle("Msg:");
//            alert.setMessage("Należy podać wartości waga, wzrost, wiek i zaznaczyć płeć");
//            alert.setButton(AlertDialog.BUTTON_NEGATIVE, "ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int witch) {
//                    dialogInterface.dismiss();
//                }
//            });
//            alert.show();
//        }
//        else {
//            if (gender == R.id.buttonMale) {
//                kCalcValue = 66.47 + 13.7 * Double.parseDouble(weightValue) + 5.0 * Double.parseDouble(highValue) - 6.76 * Double.parseDouble(ageValue);
//            }
//            else if (gender == R.id.buttonFemale) {
//                kCalcValue = 665.1 + 9.567*Double.parseDouble(weightValue) + 1.85*Double.parseDouble(highValue) - 4.68*Double.parseDouble(ageValue);
//            }
//        }
//        return kCalcValue;
//    }
//
//    private void showResult(double kCalcValue){
//        double roundKCalValue = (double) Math.round(kCalcValue * 100) /100;
//        String kCalcText = Double.toString(roundKCalValue);
//
//        kCal.setText(kCalcText);
//    }
//

//}
