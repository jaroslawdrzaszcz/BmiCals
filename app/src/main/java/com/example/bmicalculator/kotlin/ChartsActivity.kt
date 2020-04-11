package com.example.bmicalculator.kotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.content_charts.*

@SuppressLint("Registered")
class ChartsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts)

        poland.setOnClickListener{
            val country = poland.text
            setupLineChart(country as String)
        }

        china.setOnClickListener{
            val country = china.text
            setupLineChart(country as String)
        }

        italy.setOnClickListener{
            val country = italy.text
            setupLineChart(country as String)
        }

        charts_back.setOnClickListener{
            finish()
        }
    }

    private fun setupLineChart(country: String) {
        val lineChart = charts_line
        val description = Description()
        description.text = "Covid-19 days Data"
        lineChart.description = description
        var dataSet = arrayOf(
                intArrayOf(),
                intArrayOf(),
                intArrayOf()
        )

        if(country == "Poland"){
            dataSet = arrayOf(
                    intArrayOf(1, 20, 45, 60, 80, 110, 156, 240, 455, 610, 906, 1018),
                    intArrayOf(0, 0, 0, 1, 2, 6, 15, 40, 45, 55, 90, 180),
                    intArrayOf(0, 2, 5, 13, 20, 26, 35, 40, 45, 51, 55, 62))
        }
        if(country == "Italy"){
            dataSet = arrayOf(
                    intArrayOf(5, 20, 150, 300, 360, 550, 1502, 1740, 1945, 2510, 3906, 4218),
                    intArrayOf(0, 0, 0, 3, 5, 6, 9, 14, 15, 20, 29, 33),
                    intArrayOf(0, 0, 5, 15, 20, 60, 15, 40, 102, 144, 162, 180))

        }
        if(country == "China"){
            dataSet =  arrayOf(
                    intArrayOf(5, 15, 15, 30, 80, 160, 255, 406, 459, 810, 909, 1238),
                    intArrayOf(0, 0, 0, 0, 2, 6, 11, 14, 25, 33, 42, 44),
                    intArrayOf(1, 3, 3, 5, 15, 20, 35, 40, 45, 51, 60, 108))
        }

        val infectedArrayList = ArrayList<Entry>()
        val recoveredArrayList = ArrayList<Entry>()
        val deathArrayList = ArrayList<Entry>()

        for ((idx, data) in dataSet.withIndex()){
            if (idx == 0){
                for((x, y) in data.withIndex()){
                    infectedArrayList.add(Entry(x.toFloat(), y.toFloat()));
                }
            }
            if (idx == 1){
                for((x, y) in data.withIndex()){
                    recoveredArrayList.add(Entry(x.toFloat(), y.toFloat()));
                }
            }
            if (idx == 2){
                for((x, y) in data.withIndex()){
                    deathArrayList.add(Entry(x.toFloat(), y.toFloat()));
                }
            }
        }

        val infectedLineDataSet = LineDataSet(infectedArrayList, "Infected");
        val recoveredLineDataSet = LineDataSet(recoveredArrayList, "Recovered");
        val deathLineDataSet = LineDataSet(deathArrayList, "Death");

        infectedLineDataSet.lineWidth = 5f;
        infectedLineDataSet.color = Color.RED;
        infectedLineDataSet.setCircleColor(R.color.colorPrimary);
        infectedLineDataSet.highLightColor = Color.RED;
        infectedLineDataSet.setDrawValues(true);

        recoveredLineDataSet.lineWidth = 5f;
        recoveredLineDataSet.color = Color.GREEN;
        recoveredLineDataSet.setCircleColor(R.color.colorPrimary);
        recoveredLineDataSet.highLightColor = Color.RED;
        recoveredLineDataSet.setDrawValues(true);

        deathLineDataSet.lineWidth = 5f;
        deathLineDataSet.color = Color.BLACK;
        deathLineDataSet.setCircleColor(R.color.colorPrimary);
        deathLineDataSet.highLightColor = Color.RED;
        deathLineDataSet.setDrawValues(true);

        val iLineDataSetArrayList = ArrayList<LineDataSet>();
        iLineDataSetArrayList.add(infectedLineDataSet);
        iLineDataSetArrayList.add(recoveredLineDataSet);
        iLineDataSetArrayList.add(deathLineDataSet);

        //LineData is the data accord
        val infectedLineData = LineData(iLineDataSetArrayList as List<ILineDataSet>?);
        infectedLineData.setValueTextSize(13f);
        infectedLineData.setValueTextColor(Color.BLACK);

        lineChart.data = infectedLineData;
        lineChart.invalidate();
    }
}