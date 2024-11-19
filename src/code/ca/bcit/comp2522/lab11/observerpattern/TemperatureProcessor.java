package ca.bcit.comp2522.lab11.observerpattern;

/**
 * The {@code TemperatureProcessor} interface represents an observer in the observer pattern.
 * Implementations of this interface are designed to process temperature updates in Celsius.
 * This is a functional interface with a single abstract method {@code processTemperature}.
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
@FunctionalInterface
public interface TemperatureProcessor {

    /**
     * Processes the given temperature in Celsius.
     * Implementations of this method define specific actions to be performed
     * when a temperature update is received.
     *
     * @param celsius the temperature value in Celsius.
     */
    void processTemperature(final int celsius);
}
