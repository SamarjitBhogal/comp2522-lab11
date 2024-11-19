package ca.bcit.comp2522.lab11.observerpattern;

import java.util.Observable;

/**
 * Represents a furnace controller that controls the central heating furnace in a house based on a target temperature.
 * Reports if the furnace needs to turn on or off.
 *
 * <p>
 * NOTE: Temperature is set in Celsius.
 * </p>
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
public class FurnaceController extends Observable implements TemperatureProcessor {

    private final int targetTempInCelsius;

    /**
     * Constructs a new FurnaceController with the specified target temperature.
     *
     * @param targetTemperatureInCelsius The target temperature in Celsius that the furnace should maintain.
     */
    public FurnaceController(final int targetTemperatureInCelsius) {
        this.targetTempInCelsius = targetTemperatureInCelsius;
    }

    /**
     * Turns off the furnace if the temperature provided is greater than or equal to the target temperature,
     * otherwise turns on the furnace.
     *
     * <p>
     * Notifies observers of {@code FurnaceController} when the temperature is processed.
     * </p>
     *
     * @param celsius The new temperature in Celsius.
     */
    @Override
    public void processTemperature(final int celsius) {
        if(celsius >= targetTempInCelsius) {
            System.out.println("The temperature is optimal, turning the furnace off.");
        } else {
            System.out.println("The temperature is too low, turning the furnace on.");
        }
        setChanged();
        notifyObservers();
    }
}
