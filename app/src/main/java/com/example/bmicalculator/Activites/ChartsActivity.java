package com.example.bmicalculator.Activites;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.Data.ChartData;
import com.example.bmicalculator.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ChartsActivity extends AppCompatActivity {
    Button back, poland, china, italy;
    ChartData chartData = new ChartData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        back = findViewById(R.id.charts_back);
        poland = findViewById(R.id.poland);
        china = findViewById(R.id.china);
        italy = findViewById(R.id.italy);

        poland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = (String) poland.getText();
                setupLineChart(country);            }
        });

        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = (String) china.getText();
                setupLineChart(country);            }
        });


        italy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = (String) italy.getText();
                setupLineChart(country);            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupLineChart(String country) {
        LineChart lineChart = findViewById(R.id.charts_line);
        Description description = new Description();
        description.setText("Covid-19 days Data");
        lineChart.setDescription(description);
        int [][] data = new int[0][];

        if(country.equals("Poland")){
            data = chartData.polandData();
        }
        if(country.equals("Italy")){
            data = chartData.italyData();
        }
        if(country.equals("China")){
            data = chartData.chinaData();
        }

        ArrayList<Entry> infectedArrayList = new ArrayList<>();
        ArrayList<Entry> recoveredArrayList = new ArrayList<>();
        ArrayList<Entry> deathArrayList = new ArrayList<>();

        for (int i = 0; i < data[0].length; i++ ){
            infectedArrayList.add(new Entry(i, data[0][i]));
            recoveredArrayList.add(new Entry(i, data[1][i]));
            deathArrayList.add(new Entry(i, data[2][i]));
        }

        LineDataSet infectedLineDataSet = new LineDataSet(infectedArrayList, "Infected");
        LineDataSet recoveredLineDataSet = new LineDataSet(recoveredArrayList, "Recovered");
        LineDataSet deathLineDataSet = new LineDataSet(deathArrayList, "Death");

        infectedLineDataSet.setLineWidth(5f);
        infectedLineDataSet.setColor(Color.RED);
        infectedLineDataSet.setCircleColor(R.color.colorPrimary);
        infectedLineDataSet.setHighLightColor(Color.RED);
        infectedLineDataSet.setDrawValues(true);

        recoveredLineDataSet.setLineWidth(5f);
        recoveredLineDataSet.setColor(Color.GREEN);
        recoveredLineDataSet.setCircleColor(R.color.colorPrimary);
        recoveredLineDataSet.setHighLightColor(Color.RED);
        recoveredLineDataSet.setDrawValues(true);

        deathLineDataSet.setLineWidth(5f);
        deathLineDataSet.setColor(Color.BLACK);
        deathLineDataSet.setCircleColor(R.color.colorPrimary);
        deathLineDataSet.setHighLightColor(Color.RED);
        deathLineDataSet.setDrawValues(true);

        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
        iLineDataSetArrayList.add(infectedLineDataSet);
        iLineDataSetArrayList.add(recoveredLineDataSet);
        iLineDataSetArrayList.add(deathLineDataSet);

        //LineData is the data accord
        LineData infectedLineData = new LineData(iLineDataSetArrayList);
        infectedLineData.setValueTextSize(13f);
        infectedLineData.setValueTextColor(Color.BLACK);

        lineChart.setData(infectedLineData);
        lineChart.invalidate();
    }
}
