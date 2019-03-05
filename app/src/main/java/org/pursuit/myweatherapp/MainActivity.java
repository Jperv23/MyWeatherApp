package org.pursuit.myweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.myweatherapp.model.Temp;
import org.pursuit.myweatherapp.model.WeatherAdapter;
import org.pursuit.myweatherapp.model.WeatherResponse;
import org.pursuit.myweatherapp.network.MyWeatherService;
import org.pursuit.myweatherapp.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        final Retrofit retrofit = RetrofitSingleton.getRetrofitInstance();
        final MyWeatherService weatherService = retrofit.create(MyWeatherService.class);
        Call<WeatherResponse> weatherResponseCall = weatherService.getWeatherResponse();
        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d(TAG, response.body().getResponse().get(0).getPeriods().get(0).getDateTimeISO());

                List<Temp> tempList = new ArrayList<>();
                for (Temp t : response.body().getResponse().get(0).getPeriods()) {
                    tempList.add(t);
                }
                recyclerView.setAdapter(new WeatherAdapter(tempList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
