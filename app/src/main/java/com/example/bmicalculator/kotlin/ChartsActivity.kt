package com.example.bmicalculator.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R
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

        charts_back.setOnClickListener{
            finish()
        }
    }

    private fun setupLineChart(country: String) {
//        val lineChart = charts_line
//        val description = Description()
//        description.text = "Covid-19 days Data";
//        lineChart.description = description
//        var data = listOf(
//                listOf(Int)
//        )
//
//        if(country == "Poland"){
//            data = ChartData.polandData
//        }
//        if(country.equals("Italy")){
//            data = chartData.italyData()
//        }
//        if(country.equals("China")){
//            data = chartData.chinaData()
//        }
//
//        ArrayList<Entry> infectedArrayList = new ArrayList<>();
//        ArrayList<Entry> recoveredArrayList = new ArrayList<>();
//        ArrayList<Entry> deathArrayList = new ArrayList<>();
//
//        for (int i = 0; i < data[0].length; i++ ){
//            infectedArrayList.add(new Entry(i, data[0][i]));
//            recoveredArrayList.add(new Entry(i, data[1][i]));
//            deathArrayList.add(new Entry(i, data[2][i]));
//        }
//
//        LineDataSet infectedLineDataSet = new LineDataSet(infectedArrayList, "Infected");
//        LineDataSet recoveredLineDataSet = new LineDataSet(recoveredArrayList, "Recovered");
//        LineDataSet deathLineDataSet = new LineDataSet(deathArrayList, "Death");
//
//        infectedLineDataSet.setLineWidth(5f);
//        infectedLineDataSet.setColor(Color.RED);
//        infectedLineDataSet.setCircleColor(R.color.colorPrimary);
//        infectedLineDataSet.setHighLightColor(Color.RED);
//        infectedLineDataSet.setDrawValues(true);
//
//        recoveredLineDataSet.setLineWidth(5f);
//        recoveredLineDataSet.setColor(Color.GREEN);
//        recoveredLineDataSet.setCircleColor(R.color.colorPrimary);
//        recoveredLineDataSet.setHighLightColor(Color.RED);
//        recoveredLineDataSet.setDrawValues(true);
//
//        deathLineDataSet.setLineWidth(5f);
//        deathLineDataSet.setColor(Color.BLACK);
//        deathLineDataSet.setCircleColor(R.color.colorPrimary);
//        deathLineDataSet.setHighLightColor(Color.RED);
//        deathLineDataSet.setDrawValues(true);
//
//        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
//        iLineDataSetArrayList.add(infectedLineDataSet);
//        iLineDataSetArrayList.add(recoveredLineDataSet);
//        iLineDataSetArrayList.add(deathLineDataSet);
//
//        //LineData is the data accord
//        LineData infectedLineData = new LineData(iLineDataSetArrayList);
//        infectedLineData.setValueTextSize(13f);
//        infectedLineData.setValueTextColor(Color.BLACK);
//
//        lineChart.data = infectedLineData;
//        lineChart.invalidate();
//    }
    }
}