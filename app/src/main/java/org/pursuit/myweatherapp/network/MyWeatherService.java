package org.pursuit.myweatherapp.network;

import org.pursuit.myweatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyWeatherService {

    @GET("/forecasts/:auto?&format=json&filter=day&limit=7&client_id=d2ZSaYdWje45DMheTd20E&client_secret=oANF9fCiMqqmYXDEISzheCuFfiqyWwIRGyuub7C6")
    Call<WeatherResponse> getWeatherResponse();
}
