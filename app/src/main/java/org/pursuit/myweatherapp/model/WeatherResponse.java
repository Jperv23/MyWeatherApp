package org.pursuit.myweatherapp.model;

import java.util.List;

public class WeatherResponse {

    private List<Weather> response;

    public WeatherResponse(List<Weather> response) {
        this.response = response;
    }

    public List<Weather> getResponse() {
        return response;
    }
}
