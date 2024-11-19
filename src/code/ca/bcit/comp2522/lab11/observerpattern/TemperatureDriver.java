package ca.bcit.comp2522.lab11.observerpattern;

public class TemperatureDriver {
    public static void main(final String[] args) {
        // Custom Observable
        final TemperatureTracker tempTracker;

        // Custom Observers
        final FurnaceController furnaceControllerCustom;
        final HeatwaveMonitor heatwaveMonitor;
        final RoadConditionAdvisor roadAdvisor;

        // Implements Java Observable
        final FurnaceController furnaceController;
        // Implements Java Observer
        final FurnaceUsageMonitor furnaceUsageMonitor;

        tempTracker = new TemperatureTracker();
        furnaceControllerCustom = new FurnaceController(20);
        heatwaveMonitor = new HeatwaveMonitor(40);
        roadAdvisor = new RoadConditionAdvisor(-1);

        tempTracker.addTemperatureProcessor(furnaceControllerCustom);
        tempTracker.addTemperatureProcessor(heatwaveMonitor);
        tempTracker.addTemperatureProcessor(roadAdvisor);

        furnaceController = new FurnaceController(25);
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
