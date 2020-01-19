package observer_pattern.main;

import observer_pattern.data.Sky;
import observer_pattern.observer.CurrentConditionDisplay;
import observer_pattern.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setWeather(73, 50, Sky.PARTLY_CLOUDY);
        weatherData.setWeather(71, 47, Sky.CLOUDY);
        weatherData.setWeather(68, 43, Sky.CLEAR);
    }
}
