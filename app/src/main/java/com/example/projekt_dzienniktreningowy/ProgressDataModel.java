package com.example.projekt_dzienniktreningowy;

public class ProgressDataModel {
    String cwiczenie;
    String srednia;
    String max;
    String min;

    public String getCwiczenie() {
        return cwiczenie;
    }

    public String getSrednia() {
        return srednia;
    }

    public String getMax() {
        return max;
    }

    public String getMin() {
        return min;
    }

    public ProgressDataModel(String cwiczenie, String srednia, String max, String min) {
        this.cwiczenie = cwiczenie;
        this.srednia = srednia;
        this.max = max;
        this.min = min;
    }
}
