package com.example.bmicalculator.Data;

public class ChartData {
    String[] countries = {"Poland", "China", "Italy"};

    private int[][] polandData = {
            {1, 20, 45, 60, 80, 110, 156, 240, 455, 610, 906, 1018},
            {0, 0, 0, 1, 2, 6, 15, 40, 45, 55, 90, 180},
            {0, 2, 5, 13, 20, 26, 35, 40, 45, 51, 55, 62}
    };

    private int[][] chinaData = {
            {5, 20, 150, 300, 360, 550, 1502, 1740, 1945, 2510, 3906, 4218},
            {0, 0, 0, 3, 5, 6, 9, 14, 15, 20, 29, 33},
            {0, 0, 5, 15, 20, 60, 15, 40, 102, 144, 162, 180}
    };

    private int[][] italyData = {
            {5, 15, 15, 30, 80, 160, 255, 406, 459, 810, 909, 1238},
            {0, 0, 0, 0, 2, 6, 11, 14, 25, 33, 42, 44},
            {1, 3, 3, 5, 15, 20, 35, 40, 45, 51, 60, 108}
    };

    public int[][] polandData(){
        return polandData;
    }
    public int[][] chinaData(){
        return chinaData;
    }
    public int[][] italyData(){
        return italyData;
    }
}
