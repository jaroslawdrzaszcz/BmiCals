package com.example.bmicalculator.Activites;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bmicalculator.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONObject;

import java.util.ArrayList;

public class ChartsActivity extends AppCompatActivity {
    Button back;
    String data = "/home/jaro/AndroidStudioProjects/BmiCalculator/app/src/main/res/values/covid-19_data.json";
    JSONObject JsonData = null;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    float[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

//    try {
//        JsonData = new JSONObject(data);
//        prin
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        back = findViewById(R.id.charts_back);

        setupLineChart();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupLineChart() {
        LineChart lineChart = findViewById(R.id.charts_line);

        ArrayList<Entry> entryArrayList = new ArrayList<>();

        for (int i = 0; i < yAxisData.length; i++ ){
            entryArrayList.add(new Entry(i, yAxisData[i], axisData[i]));
        }

        LineDataSet lineDataSet = new LineDataSet(entryArrayList, "This is y bill");
        lineDataSet.setLineWidth(5f);
        lineDataSet.setColor(Color.GRAY);
        lineDataSet.setCircleColor(R.color.colorPrimary);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setDrawValues(false);
        lineDataSet.setCircleRadius(10f);
        lineDataSet.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet.setCubicIntensity(0.2f);

        //to remove the cricle from the graph
        lineDataSet.setDrawCircles(false);

        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
        iLineDataSetArrayList.add(lineDataSet);

        //LineData is the data accord
        LineData lineData = new LineData(iLineDataSetArrayList);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}
