package org.pursuit.myweatherapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.myweatherapp.R;
import org.pursuit.myweatherapp.model.Temp;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    //    private ToggleButton changeDegreeButton;
    private TextView dateView;
    private ImageView weatherIcon;
    private TextView weatherPrimaryView;
    private TextView maxTempView;
    private TextView minTempView;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
//        changeDegreeButton = itemView.findViewById(R.id.change_degree_button);
        dateView = itemView.findViewById(R.id.date_view);
        weatherIcon = itemView.findViewById(R.id.weather_icon_view);
        weatherPrimaryView = itemView.findViewById(R.id.weatherPrimary_view);
        maxTempView = itemView.findViewById(R.id.maxTemp_view);
        minTempView = itemView.findViewById(R.id.minTemp_view);
    }

    public void onBind(final Temp temp) {
//        changeDegreeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                changeDegreeButton.setTextOn("Show °C");
////                changeDegreeButton.setTextOff("Show °F");
//                if (isChecked) {
//                    maxTempView.setText(String.valueOf(temp.getMaxTempC()) + "°C");
//                    minTempView.setText(String.valueOf(temp.getMinTempC()) + "°C");
//                } else {
//                    maxTempView.setText(String.valueOf(temp.getMaxTempF()) + "°F");
//                    minTempView.setText(String.valueOf(temp.getMinTempF()) + "°F");
//                }
//            }
//        });
        String date = temp.getDateTimeISO().substring(0, 10);
        dateView.setText(date);

        String icon = temp.getIcon().substring(0, temp.getIcon().length() - 4);
        int id = itemView.getResources().getIdentifier(icon, "drawable", itemView.getContext().getPackageName());

        Picasso.get()
                .load(id)
                .resize(200, 200)
                .into(weatherIcon);
        weatherPrimaryView.setText(temp.getWeatherPrimary());

        maxTempView.setText(String.valueOf(temp.getMaxTempF()) + "°F");
        minTempView.setText(String.valueOf(temp.getMinTempF()) + "°F");
    }
}