package org.pursuit.myweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import org.pursuit.myweatherapp.controller.WeatherAdapter;
import org.pursuit.myweatherapp.model.Temp;
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

    private ToggleButton changeDegreeButton;
//    private TextView maxTempView;
//    private TextView minTempView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeDegreeButton = findViewById(R.id.change_degree_button);
//        maxTempView = findViewById(R.id.maxTemp_view);
//        minTempView = findViewById(R.id.minTemp_view);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        final Retrofit retrofit = RetrofitSingleton.getRetrofitInstance();
        final MyWeatherService weatherService = retrofit.create(MyWeatherService.class);
        Call<WeatherResponse> weatherResponseCall = weatherService.getWeatherResponse();
        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, final Response<WeatherResponse> response) {
                Log.d(TAG, response.body().getResponse().get(0).getPeriods().get(0).getDateTimeISO());

                final List<Temp> tempList = new ArrayList<>();
                for (Temp t : response.body().getResponse().get(0).getPeriods()) {
                    tempList.add(t);
                }

                changeDegreeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        changeDegreeButton.setTextOn("Show °F");
                        changeDegreeButton.setTextOff("Show °C");
                        if (isChecked) {
//                            maxTempView.setText(tempList.get(0).getMaxTempC() + "°C");
//                            minTempView.setText(String.valueOf(temp.getMinTempC()) + "°C");
                        } else {
//                            maxTempView.setText(String.valueOf(temp.getMaxTempF()) + "°F");
//                            minTempView.setText(String.valueOf(temp.getMinTempF()) + "°F");
                        }
                    }
                });

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
