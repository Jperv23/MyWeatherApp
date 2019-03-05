package org.pursuit.myweatherapp.model;

public class Temp {

    private String dateTimeISO;
    private int maxTempF;
    private int minTempF;
    private String weatherPrimary;
    private String icon;
//    private int maxTempC;
//    private int minTempC;


    public Temp(String dateTimeISO, int maxTempF, int minTempF, String weatherPrimary, String icon) {
        this.dateTimeISO = dateTimeISO;
        this.maxTempF = maxTempF;
        this.minTempF = minTempF;
        this.weatherPrimary = weatherPrimary;
        this.icon = icon;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public int getMaxTempF() {
        return maxTempF;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public String getWeatherPrimary() {
        return weatherPrimary;
    }

    public String getIcon() {
        return icon;
    }
}
