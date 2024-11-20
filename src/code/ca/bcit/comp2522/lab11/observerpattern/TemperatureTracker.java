package ca.bcit.comp2522.lab11.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TemperatureTracker} class is an observable that tracks temperature updates
 * and notifies registered observers (processors) whenever the temperature changes.
 * It accepts temperature readings in Celsius, Fahrenheit, and Kelvin,
 * converts them to Celsius, and announces updates to all observers.
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
public class TemperatureTracker {
    private final static int FREEZING_POINT_FAHRENHEIT = 32;
    private final static float CONV_FACTOR_NUMERATOR = 5.0f;
    private final static float CONV_FACTOR_DENOMINATOR = 9.0f;
    private final static float KELVIN_TO_CELSIUS_OFFSET = 273.15f;

    private int currentTemperatureCelsius;
    private final List<TemperatureProcessor> processors;

    /**
     * Constructs a new {@code TemperatureTracker} instance.
     * Initializes the list of temperature processors (observers)
     * that will be notified of temperature updates.
     */
    public TemperatureTracker() {
        processors = new ArrayList<>();
    }

    /**
     * Accepts a temperature reading in Celsius and updates the current temperature.
     *
     * @param celsius the temperature in Celsius.
     */
    public void takeInCelsiusReading(final int celsius) {
        setCurrentTemperature(celsius);
    }

    /**
     * Accepts a temperature reading in Fahrenheit, converts it to Celsius, and updates the current temperature.
     *
     * @param fahrenheit the temperature in Fahrenheit.
     */
    public void takeInFahrenheitReading(final int fahrenheit) {
        setCurrentTemperature(fahrenheitToCelsius(fahrenheit));
    }

    /**
     * Accepts a temperature reading in kelvin, converts it to Celsius and updates the current temperature.
     *
     * @param kelvin the temperature in kelvin.
     */
    public void takeInKelvinReading(final int kelvin) {
        setCurrentTemperature(kelvinToCelsius(kelvin));
    }

    /**
     * Adds a new temperature processor (observer) to the tracker.
     *
     * @param processor the {@code TemperatureProcessor} to add.
     */
    public void addTemperatureProcessor(final TemperatureProcessor processor) {
        if(processor == null) {
            throw new IllegalArgumentException("Cannot add a null TemperatureProcessor to TemperatureTracker.");
        }

        processors.add(processor);
    }

    /**
     * Removes a temperature processor (observer) from the tracker.
     *
     * @param processor the {@code TemperatureProcessor} to remove.
     */
    public void removeTemperatureProcessor(final TemperatureProcessor processor) {
        if(processor == null) {
            throw new IllegalArgumentException("Cannot remove a null TemperatureProcessor from TemperatureTracker.");
        }

        processors.remove(processor);
    }

    /* Converts a temperature from Fahrenheit to Celsius. */
    private int fahrenheitToCelsius(final int fahrenheit) {
        return Math.round((fahrenheit - FREEZING_POINT_FAHRENHEIT) * CONV_FACTOR_NUMERATOR / CONV_FACTOR_DENOMINATOR);
    }

    /* Converts a temperature from Kelvin to Celsius. */
    private int kelvinToCelsius(final int kelvin) {
        return Math.round(kelvin - KELVIN_TO_CELSIUS_OFFSET);
    }

    /* Sets the current temperature in Celsius and notifies all registered processors. */
    private void setCurrentTemperature(final int celsius) {
        currentTemperatureCelsius = celsius;
        notifyProcessors();
    }

    /* Notifies all registered processors of the current temperature. */
    private void notifyProcessors() {
        for(final TemperatureProcessor processor : processors) {
            if(processor != null) {
                processor.processTemperature(currentTemperatureCelsius);
            }
        }
    }
}
