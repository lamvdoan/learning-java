package observer_pattern.observer;

import observer_pattern.data.Sky;

public interface Observer {
    void update(double temperature, double humidity, Sky sky);
}
