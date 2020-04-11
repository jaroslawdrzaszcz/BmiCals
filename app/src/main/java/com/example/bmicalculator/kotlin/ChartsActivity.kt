package com.example.bmicalculator.kotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.Data.ChartKotlinData
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
            dataSet = ChartKotlinData().polandData()!!
        }
        if(country == "Italy"){
            dataSet = ChartKotlinData().italyData()!!
        }
        if(country == "China"){
            dataSet = ChartKotlinData().chinaData()!!
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