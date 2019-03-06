package org.pursuit.myweatherapp.model;

public class Temp {

    private String dateTimeISO;
    private int maxTempF;
    private int minTempF;
    private int maxTempC;
    private int minTempC;
    private String weatherPrimary;
    private String icon;

    public Temp(String dateTimeISO, int maxTempF, int minTempF,
                int maxTempC, int minTempC, String weatherPrimary, String icon) {
        this.dateTimeISO = dateTimeISO;
        this.maxTempF = maxTempF;
        this.minTempF = minTempF;
        this.maxTempC = maxTempC;
        this.minTempC = minTempC;
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

    public int getMaxTempC() {
        return maxTempC;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public String getWeatherPrimary() {
        return weatherPrimary;
    }

    public String getIcon() {
        return icon;
    }
}
