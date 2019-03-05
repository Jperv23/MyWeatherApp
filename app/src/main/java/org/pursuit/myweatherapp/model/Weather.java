package org.pursuit.myweatherapp.model;

import java.util.List;

public class Weather {

    private List<Temp> periods;

    public Weather(List<Temp> periods) {
        this.periods = periods;
    }

    public List<Temp> getPeriods() {
        return periods;
    }
}
