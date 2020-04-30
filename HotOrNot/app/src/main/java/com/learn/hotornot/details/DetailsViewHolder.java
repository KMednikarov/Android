package com.learn.hotornot.details;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.hotornot.R;
import com.learn.hotornot.data.models.ForecastWeather;

import java.text.SimpleDateFormat;
import java.util.Date;

class DetailsViewHolder extends RecyclerView.ViewHolder{
    private static final int MILLISECONDS = 1000;
    private static final String DATE_FORMAT = "dd/MM";
    private static final String PERCENTAGE_SIGN = "%";
    private static final String SPEED_MEASUREMENT_SIGN = "m/s";
    private static final String TODAY = "Today";
    private static final String CELSIUS_SIGN = "\u2103";
    private static final String CLEAR = "CLEAR";
    private static final String CLOUDS = "CLOUDS";
    private static final String RAIN = "RAIN";
    private TextView mTextViewTemperature;
    private TextView mTextViewDay;
    private TextView mTextViewClouds;
    private TextView mTextViewWindSpeed;
    private TextView mTextViewHumidity;
    private TextView mTextViewWeatherType;
    private ImageView mImageViewWeatherBackground;

    public DetailsViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewTemperature = itemView.findViewById(R.id.txt_temperature);
        mTextViewDay = itemView.findViewById(R.id.txt_day);
        mTextViewClouds = itemView.findViewById(R.id.txt_clouds);
        mTextViewWindSpeed = itemView.findViewById(R.id.txt_wind_speed);
        mTextViewHumidity = itemView.findViewById(R.id.txt_humidity);
        mTextViewWeatherType = itemView.findViewById(R.id.txt_weather_type);
        mImageViewWeatherBackground = itemView.findViewById(R.id.img_weather_background);
    }

    public void setData(ForecastWeather forecast) {
        String temperature = forecast.getTemperatureData().getDailyTemperature() + CELSIUS_SIGN;
        String windSpeed = forecast.getWindSpeed() + SPEED_MEASUREMENT_SIGN;
        String humidity = forecast.getHumidity() + PERCENTAGE_SIGN;
        String forecastDate = getFormattedDate(forecast.getTimestamp());
        String weatherType = forecast.getWeatherMetaData().get(0).getWeatherName();
        String cloudPercentage = forecast.getClouds() + PERCENTAGE_SIGN;
        int weatherImageId = getWeatherImage(weatherType);

        mTextViewTemperature.setText(temperature);
        mTextViewDay.setText(forecastDate);
        mTextViewWindSpeed.setText(windSpeed);
        mTextViewHumidity.setText(humidity);
        mTextViewWeatherType.setText(weatherType);
        mTextViewClouds.setText(cloudPercentage);
        mImageViewWeatherBackground.setImageResource(weatherImageId);
    }

    private int getWeatherImage(String weatherType) {

        int result = -1;
        switch (weatherType.toUpperCase()){
            case CLEAR:
                result = R.drawable.ic_wi_day_sunny;
                break;
            case CLOUDS:
                result = R.drawable.ic_wi_cloudy;
                break;
            case RAIN:
                result = R.drawable.ic_wi_rain;
                break;
            default:
                break;
        }
        return result;
    }

    private String getFormattedDate(long timestamp){
        return new SimpleDateFormat(DATE_FORMAT).format(new Date(timestamp*MILLISECONDS));
    }
}
