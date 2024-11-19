package ca.bcit.comp2522.lab11.observerpattern;

/**
 * Represents a heatwave detector that monitors for high temperatures that could be dangerous to a population.
 * Reports if the temperature exceeds the temperature limit.
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
public class HeatwaveMonitor implements TemperatureProcessor {

    private final int tempLimitInCelsius;

    /**
     * Constructs a new HeatwaveMonitor with the specified temperature limit.
     *
     * @param tempLimitInCelsius The temperature limit in Celsius for triggering a heatwave warning.
     */
    public HeatwaveMonitor(final int tempLimitInCelsius) {
        this.tempLimitInCelsius = tempLimitInCelsius;
    }

    /**
     * Checks if the provided temperature exceeds the set temperature limit and issues a warning if necessary.
     *
     * @param celsius The current temperature in Celsius.
     */
    @Override
    public void processTemperature(final int celsius) {
        if(celsius > tempLimitInCelsius) {
            System.out.printf("Warning! Hazardous temperature detected! Temperature is now %d °C which exceeds "
                              + "the limit of %d °C%n", celsius, tempLimitInCelsius);
        }
    }
}

