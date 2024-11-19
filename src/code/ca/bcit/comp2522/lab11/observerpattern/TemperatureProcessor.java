package ca.bcit.comp2522.lab11.observerpattern;

@FunctionalInterface
public interface TemperatureProcessor {
    void processTemperature(final int celsius);
}
