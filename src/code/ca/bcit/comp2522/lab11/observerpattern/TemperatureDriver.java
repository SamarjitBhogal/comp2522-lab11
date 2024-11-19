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

        // TODO: Adjust temps in tempTracker to display all the different outputs
    }
}
