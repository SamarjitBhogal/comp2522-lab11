package ca.bcit.comp2522.lab11.observerpattern;

public class TemperatureDriver {
    public static void main(final String[] args) {
        final TemperatureTracker tempTracker;
        final FurnaceController furnaceControllerCustom;
        final HeatwaveMonitor heatwaveMonitor;
        final RoadConditionAdvisor roadAdvisor;

        tempTracker = new TemperatureTracker();
        furnaceControllerCustom = new FurnaceController(20);
        heatwaveMonitor = new HeatwaveMonitor(40);
        roadAdvisor = new RoadConditionAdvisor(-1);
    }
}
