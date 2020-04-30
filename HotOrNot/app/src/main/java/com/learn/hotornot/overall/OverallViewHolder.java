package com.learn.hotornot.overall;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.hotornot.R;
import com.learn.hotornot.data.models.CurrentWeather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OverallViewHolder extends RecyclerView.ViewHolder {
    private static final String DATE_FORMAT = "dd/MM";
    public static final String TODAY = "Today";
    public static final String PERCENTAGE_SIGN = "%";
    private static final String SPEED_MEASUREMENT_SIGN = "m/s";
    private static final String CELSIUS_SIGN = "\u2103";
    private static final long MILLISECONDS = 1000;
    private TextView mTextViewTemperature;
    private TextView mTextViewDay;
    private TextView mTextViewClouds;
    private TextView mTextViewWindSpeed;
    private TextView mTextViewHumidity;
    private TextView mTextViewWeatherType;

    public OverallViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewTemperature = itemView.findViewById(R.id.txt_temperature);
        mTextViewDay = itemView.findViewById(R.id.txt_day);
        mTextViewClouds = itemView.findViewById(R.id.txt_clouds);
        mTextViewWindSpeed = itemView.findViewById(R.id.txt_wind_speed);
        mTextViewHumidity = itemView.findViewById(R.id.txt_humidity);
        mTextViewWeatherType = itemView.findViewById(R.id.txt_weather_type);
    }

    public void setData(CurrentWeather weather) {
        String temperature = weather.getTemperatureData() + CELSIUS_SIGN;
        String windSpeed = weather.getWindSpeed() + SPEED_MEASUREMENT_SIGN;
        String humidity = weather.getHumidity() + PERCENTAGE_SIGN;
        String date = getFormattedDate(weather.getTimestamp());
        String weatherType = weather.getWeatherMetaData().get(0).getWeatherName();
        String cloudPercentage = weather.getClouds() + PERCENTAGE_SIGN;

        mTextViewTemperature.setText(temperature);
        mTextViewDay.setText(date);
        mTextViewWindSpeed.setText(windSpeed);
        mTextViewHumidity.setText(humidity);
        mTextViewWeatherType.setText(weatherType);
        mTextViewClouds.setText(cloudPercentage);
    }

    private String getFormattedDate(long timestamp) {
        String today = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        String forecastDate = new SimpleDateFormat(DATE_FORMAT).format(new Date(timestamp * MILLISECONDS));

        if (forecastDate.equals(today)) {
            return TODAY;
        }

        return forecastDate;
    }
}
