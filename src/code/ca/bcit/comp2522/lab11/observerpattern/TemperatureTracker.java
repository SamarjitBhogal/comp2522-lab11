package ca.bcit.comp2522.lab11.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class TemperatureTracker {
    private int currentTemperatureCelsius;
    private final List<TemperatureProcessor> processors = new ArrayList<>();

    private int fahrenheitToCelsius(final int fahrenheit) {
        return Math.round((fahrenheit - 32) * 5 / 9.0f);
    }

    private int kelvinToCelsius(final int kelvin) {
        return Math.round(kelvin - 273.15f);
    }

    private void setCurrentTemperature(final int celsius) {
        currentTemperatureCelsius = celsius;
        notifyProcessors();
    }

    private void notifyProcessors() {
        for (TemperatureProcessor processor : processors) {
            processor.processTemperature(currentTemperatureCelsius);
        }
    }

    public void takeInCelsiusReading(final int celsius) {
        setCurrentTemperature(celsius);
    }

    public void takeInFahrenheitReading(final int kelvin) {
        setCurrentTemperature(kelvinToCelsius(kelvin));
    }

    public void addTemperatureProcessor(final TemperatureProcessor processor) {
        processors.add(processor);
    }

    public void removeTemperatureProcessor(final TemperatureProcessor processor) {
        processors.remove(processor);
    }
}
