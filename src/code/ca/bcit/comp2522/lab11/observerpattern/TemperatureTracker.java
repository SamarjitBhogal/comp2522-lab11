package ca.bcit.comp2522.lab11.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class TemperatureTracker {
    private final static int FREEZING_POINT_FAHRENHEIT = 32;
    private final static float CONV_FACTOR_NUMERATOR = 5.0f;
    private final static float CONV_FACTOR_DENOMINATOR = 9.0f;
    private final static float KELVIN_TO_CELSIUS_OFFSET = 273.15f;

    private int currentTemperatureCelsius;
    private final List<TemperatureProcessor> processors = new ArrayList<>();

    private int fahrenheitToCelsius(final int fahrenheit) {
        return Math.round((fahrenheit - FREEZING_POINT_FAHRENHEIT) * CONV_FACTOR_NUMERATOR / CONV_FACTOR_DENOMINATOR);
    }

    private int kelvinToCelsius(final int kelvin) {
        return Math.round(kelvin - KELVIN_TO_CELSIUS_OFFSET);
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
