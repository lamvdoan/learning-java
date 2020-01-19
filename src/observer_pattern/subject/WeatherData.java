package observer_pattern.subject;

import observer_pattern.data.Sky;
import observer_pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private double temperature;
    private double humidity;
    private Sky sky;


    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);

        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, sky);
        }
    }

    public void setWeather(double temperature, double humidity, Sky sky) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.sky = sky;

        notifyObserver();
    }
}
