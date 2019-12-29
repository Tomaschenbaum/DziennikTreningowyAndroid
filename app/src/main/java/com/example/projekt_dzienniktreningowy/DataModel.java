package com.example.projekt_dzienniktreningowy;

public class DataModel {
    String cwiczenie;
    String data;
    String obciazenie;
    String serie;

    public String getCwiczenie() {
        return cwiczenie;
    }

    public String getData() {
        return data;
    }

    public String getObciazenie() {
        return obciazenie;
    }

    public String getSerie() {
        return serie;
    }

    public DataModel(String cwiczenie, String data, String obciazenie, String serie) {
        this.cwiczenie = cwiczenie;
        this.data = data;
        this.obciazenie = obciazenie;
        this.serie = serie;
    }
}
