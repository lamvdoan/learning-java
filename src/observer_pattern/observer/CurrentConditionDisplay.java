package observer_pattern.observer;

import observer_pattern.data.Sky;
import observer_pattern.subject.Subject;

public class CurrentConditionDisplay implements Observer {
    private Subject weatherData;
    private double temperature;
    private double humidity;
    private Sky sky;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, Sky sky) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.sky = sky;

        display();
    }

    public void display() {
        System.out.println("Temperature: " + temperature +
                "F degrees, Humidity: " + humidity +
                "%, Skies: " + sky);
    }
}
