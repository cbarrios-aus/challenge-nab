package com.cab.challenge.core.models.beans;


public class Currency {

    private String time;
    private double value;

    public Currency(String time, double value) {
        this.time = time;
        this.value = value;
    }

    public Currency(double value) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void seTime(String time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFormattedTime() {
        return time.substring(0,2) + ":" + time.substring(2);
    }

}
