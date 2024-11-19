package ca.bcit.comp2522.lab11.observerpattern;

/**
 * Monitors for freezing temperatures that could result in dangerous conditions on the road.
 * Reports if the temperature passes the set threshold.
 *
 * <p>
 * NOTE: Temperature is set in Celsius
 * </p>
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
public class RoadConditionAdvisor implements TemperatureProcessor {

    private final int thresholdTempInCelsius;

    /**
     * Constructs a new RoadConditionAdvisor with the specified threshold temperature.
     *
     * @param thresholdTempInCelsius The threshold temperature in Celsius. Must be less than or equal to 0.
     */
    public RoadConditionAdvisor(final int thresholdTempInCelsius) {
        validateThreshold(thresholdTempInCelsius);
        this.thresholdTempInCelsius = thresholdTempInCelsius;
    }

    /**
     * Checks if the provided temperature is below the set threshold and issues a warning if necessary.
     *
     * @param celsius The current temperature in Celsius.
     */
    @Override
    public void processTemperature(final int celsius) {
        if(celsius < thresholdTempInCelsius) {
            System.out.printf("Warning! Temperature is now below the threshold! Temperature is now %d °C which "
                              + "is past the threshold of %d °C%n", celsius, thresholdTempInCelsius);
        }
    }

    /*
     * Validates the threshold temperature. Ensures it is appropriate for freezing conditions.
     */
    private static void validateThreshold(final int thresholdTempInCelsius) {
        if(thresholdTempInCelsius > 0) {
            throw new IllegalArgumentException("A RoadConditionAdvisor can only be created for freezing temperatures.");
        }
    }
}
