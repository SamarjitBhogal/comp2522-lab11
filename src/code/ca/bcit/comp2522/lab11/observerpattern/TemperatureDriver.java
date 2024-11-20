package ca.bcit.comp2522.lab11.observerpattern;

/**
 * The entry point for the temperature tracking application.
 * This class demonstrates the Observer design pattern by tracking temperature
 * and notifying various observers about changes.
 *
 * <p>
 * Observers:
 * <ul>
 *   <li>FurnaceController</li>
 *   <li>HeatwaveMonitor</li>
 *   <li>RoadConditionAdvisor</li>
 *   <li>FurnaceUsageMonitor (via Java Observer)</li>
 * </ul>
 *
 * Observables:
 * <ul>
 *   <li>TemperatureTracker</li>
 *   <li>FurnaceController (via Java Observable)</li>
 * </ul>
 */
public class TemperatureDriver {

    /**
     * The main method where the program starts execution.
     * It initializes the TemperatureTracker and various observers,
     * attaches the observers to the tracker, and simulates temperature readings
     * in different units.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(final String[] args) {
        // Custom Observable
        final TemperatureTracker tempTracker;

        // Custom Observers

        // FurnaceController Implements Java Observable
        final FurnaceController furnaceController;
        final HeatwaveMonitor heatwaveMonitor;
        final RoadConditionAdvisor roadAdvisor;

        // FurnaceUsageMonitor Implements Java Observer
        final FurnaceUsageMonitor furnaceUsageMonitor;

        // Initialize the TemperatureTracker (observable) and observers
        tempTracker = new TemperatureTracker();
        furnaceController = new FurnaceController(20);
        heatwaveMonitor = new HeatwaveMonitor(40);
        roadAdvisor = new RoadConditionAdvisor(-1);

        // Attach observers to the TemperatureTracker
        tempTracker.addTemperatureProcessor(furnaceController);
        tempTracker.addTemperatureProcessor(heatwaveMonitor);
        tempTracker.addTemperatureProcessor(roadAdvisor);

        // Attach FurnaceUsageMonitor to FurnaceController
        furnaceUsageMonitor = new FurnaceUsageMonitor();
        furnaceController.addObserver(furnaceUsageMonitor);

        // Trigger temperature readings to test all observers
        System.out.println("Temperature in Celsius: 15°C\n");
        tempTracker.takeInCelsiusReading(15);

        System.out.println("Temperature in Fahrenheit: 77°F (25°C)\n");
        tempTracker.takeInFahrenheitReading(77);

        System.out.println("Temperature in Kelvin: 313K (40°C)\n");
        tempTracker.takeInKelvinReading(313);

        System.out.println("Temperature in Celsius: -5°C\n");
        tempTracker.takeInCelsiusReading(-5);

        System.out.println("Temperature in Fahrenheit: 5°F (-15°C)\n");
        tempTracker.takeInFahrenheitReading(5);

        System.out.println("Temperature in Kelvin: 255K (-18°C)\n");
        tempTracker.takeInKelvinReading(255);

        System.out.println("Temperature in Celsius: 45°C\n");
        tempTracker.takeInCelsiusReading(45);
    }
}
