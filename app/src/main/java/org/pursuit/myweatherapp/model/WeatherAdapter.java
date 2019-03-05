package org.pursuit.myweatherapp.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.myweatherapp.R;
import org.pursuit.myweatherapp.view.WeatherViewHolder;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private List<Temp> tempList;

    public WeatherAdapter(List<Temp> tempList) {
        this.tempList = tempList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weather_itemview, viewGroup, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        weatherViewHolder.onBind(tempList.get(i));
    }

    @Override
    public int getItemCount() {
        return tempList.size();
    }
}
