package org.pursuit.myweatherapp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.myweatherapp.R;
import org.pursuit.myweatherapp.model.Temp;

import java.io.File;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView dateView;
    private ImageView weatherIcon;
    private TextView maxTempView;
    private TextView minTempView;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        dateView = itemView.findViewById(R.id.date_view);
        weatherIcon = itemView.findViewById(R.id.weather_icon_view);
        maxTempView = itemView.findViewById(R.id.maxTemp_view);
        minTempView = itemView.findViewById(R.id.minTemp_view);
    }

    public void onBind(final Temp temp) {
        dateView.setText(temp.getDateTimeISO());

        String drawableName = "R.drawable." + temp.getIcon();
        Picasso.get()
                .load(drawableName)
                .resize(400, 400)
                .into(weatherIcon);

        maxTempView.setText(String.valueOf(temp.getMaxTempF()) + "°F");
        minTempView.setText(String.valueOf(temp.getMinTempF()) + "°F");
    }
}
