package com.example.projectuas.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectuas.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

   HorizontalBarChart h_chartbar;
   BarChart v_chartbar;
   PieChart pieChart;
   ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        h_chartbar = findViewById(R.id.h_chart);
        v_chartbar = findViewById(R.id.v_chartbar);
        pieChart = findViewById(R.id.pie_chart);
        horizontal_barchart();
        vertical_barchart();
        pie_bar();
        imageView=findViewById(R.id.exitIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void horizontal_barchart(){
        //create bar values
        ArrayList barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0,5));
        barEntries.add(new BarEntry(1,5));
        barEntries.add(new BarEntry(2,5));
        barEntries.add(new BarEntry(3,6));
        barEntries.add(new BarEntry(4,6));
        barEntries.add(new BarEntry(5,7));
        barEntries.add(new BarEntry(6,11));
        barEntries.add(new BarEntry(7,11));
        barEntries.add(new BarEntry(8,12));
        barEntries.add(new BarEntry(9,14));
        barEntries.add(new BarEntry(10,16));
        barEntries.add(new BarEntry(11,21));
        // create List Tabel
        ArrayList PremiereLeague=new ArrayList<>();
        PremiereLeague.add("Afrika Selatan");
        PremiereLeague.add("Tunisia");
        PremiereLeague.add("Rumania");
        PremiereLeague.add("Sri Lanka");
        PremiereLeague.add("Kolombia");
        PremiereLeague.add("Nigeria");
        PremiereLeague.add("China");
        PremiereLeague.add("Bangladesh");
        PremiereLeague.add("Afganistan");
        PremiereLeague.add("Vietnam");
        PremiereLeague.add("Indonesia");
        PremiereLeague.add("India");

        BarDataSet barSet=new BarDataSet(barEntries,"");

        barSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData=new BarData(barSet);

        h_chartbar.setData(barData);
        h_chartbar.animateY(2000);
        h_chartbar.setFitBars(true);

        Description description=new Description();
        description.setText("Peningkatan sanitasi dasar sejak 2015");
        h_chartbar.setDescription(description);

        h_chartbar.getXAxis().setLabelCount(12);
        h_chartbar.setExtraRightOffset(5f);

        barData.setValueTextSize(14f);
        h_chartbar.invalidate();

        Legend legend=h_chartbar.getLegend();
        legend.setEnabled(true);

        XAxis xAxis=h_chartbar.getXAxis();
        xAxis.setDrawGridLines(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setDrawLabels(true);
        xAxis.setXOffset(10);
        xAxis.setDrawAxisLine(true);


        h_chartbar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(PremiereLeague));
        h_chartbar.getXAxis().setGranularity(0.2f);
        h_chartbar.getXAxis().setGranularityEnabled(true);
    }
    public void vertical_barchart(){
        //create bar values
        ArrayList barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0,140));
        barEntries.add(new BarEntry(1,139));
        barEntries.add(new BarEntry(2,141));
        barEntries.add(new BarEntry(3,145));
        barEntries.add(new BarEntry(4,139));
        barEntries.add(new BarEntry(5,153));
        barEntries.add(new BarEntry(6,149));
        barEntries.add(new BarEntry(7,147));
        barEntries.add(new BarEntry(8,145));
        barEntries.add(new BarEntry(9,146));
        barEntries.add(new BarEntry(10,157));
        // create List Tabel
        ArrayList PremiereLeague=new ArrayList<>();
        PremiereLeague.add("2010");
        PremiereLeague.add("2011");
        PremiereLeague.add("2012");
        PremiereLeague.add("2013");
        PremiereLeague.add("2014");
        PremiereLeague.add("2015");
        PremiereLeague.add("2016");
        PremiereLeague.add("2017");
        PremiereLeague.add("2018");
        PremiereLeague.add("2019");
        PremiereLeague.add("2020");

        BarDataSet barSet=new BarDataSet(barEntries,"");

        barSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData=new BarData(barSet);

        v_chartbar.setData(barData);
        v_chartbar.animateY(2000);
        v_chartbar.setFitBars(true);

        Description description=new Description();
        description.setText("Konsumsi Air Minum Periode 2010-2020");
        v_chartbar.setDescription(description);

        v_chartbar.getXAxis().setLabelCount(12);
        v_chartbar.setExtraRightOffset(10f);

        barData.setValueTextSize(8f);
        v_chartbar.invalidate();

        Legend legend=v_chartbar.getLegend();
        legend.setEnabled(true);

        XAxis xAxis=v_chartbar.getXAxis();
        xAxis.setDrawGridLines(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setDrawLabels(true);
        xAxis.setXOffset(10);
        xAxis.setDrawAxisLine(true);


        v_chartbar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(PremiereLeague));
        v_chartbar.getXAxis().setGranularity(0.2f);
        v_chartbar.getXAxis().setGranularityEnabled(true);

        v_chartbar.getAxisRight().setEnabled(false);
        v_chartbar.getAxisLeft().setEnabled(false);
    }
    public void pie_bar() {
        ArrayList<PieEntry> entiers = new ArrayList<>();
        entiers.add(new PieEntry(13.7f,"industri"));
        entiers.add(new PieEntry(6.81f,"Sosial"));
        entiers.add(new PieEntry(2.65f,"Pemerintah"));
        entiers.add(new PieEntry(77.17f,"Rumah Tangga"));


        PieDataSet pieDataSet = new PieDataSet(entiers,"volume air bersih");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieChart.getDescription().setEnabled(false);
        pieChart.animateY(1000);
        pieChart.invalidate();
    }
}