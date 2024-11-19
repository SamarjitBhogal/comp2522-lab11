package ca.bcit.comp2522.lab11.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Monitors {@code FurnaceController} objects by tracking the duration of time, in milliseconds,
 * that the furnace spent in the “on” state.
 *
 * <p>
 * NOTE: Temperature is set in Celsius.
 * </p>
 *
 * @author Samarjit Bhogal
 * @author Raven Saballa
 * @version 1.0
 */
public class FurnaceUsageMonitor implements Observer {

    private static final int NULL_START_MILLISECONDS = 0;

    private boolean furnaceOnState;
    private long startMilliseconds;

    /**
     * Constructs a new {@code FurnaceUsageMonitor} with the initial state of the furnace set to "off."
     */
    public FurnaceUsageMonitor() {
        furnaceOnState = false;
        startMilliseconds = NULL_START_MILLISECONDS;
    }

    /**
     * Updates the monitor based on a message from an observable furnace controller.
     * Tracks the time the furnace spends in the "on" state.
     *
     * <p>
     * NOTE: Only starts updating on first "on" state of the Observable furnace.
     * </p>
     *
     * <p>
     * NOTE: The messageObj MUST be a String with a message of "on" or "off" for this update to work.
     * </p>
     *
     * @param o          The observable furnace controller that notified this observer.
     * @param messageObj The message sent by the observable, expected to be a {@code String}.
     * @throws IllegalArgumentException If the message is invalid or not a {@code String}.
     */
    @Override
    public void update(final Observable o, final Object messageObj) {
        if(messageObj instanceof String) {
            final String message;
            message = (String) messageObj;

            if(message.equalsIgnoreCase(FurnaceController.FURNACE_ON_MESSAGE)) {
                if(!furnaceOnState) {
                    setFurnaceOnState(true);
                    setStartMilliseconds();
                }
            } else if(message.equalsIgnoreCase(FurnaceController.FURNACE_OFF_MESSAGE)) {
                if(furnaceOnState) {
                    setFurnaceOnState(false);

                    final long endMilliseconds;
                    final long millisecondsElapsed;

                    endMilliseconds = System.currentTimeMillis();
                    millisecondsElapsed = endMilliseconds - startMilliseconds;

                    System.out.println("The furnace was on for " + millisecondsElapsed + " milliseconds.");
                }
            } else {
                throw new IllegalArgumentException("Could not update FurnaceUsageMonitor with invalid message.");
            }
        } else {
            throw new IllegalArgumentException("Could not update FurnaceUsageMonitor with invalid message object.");
        }
    }

    /*
     * Sets the furnace's "on" state.
     */
    private void setFurnaceOnState(final boolean furnaceOnState) {
        this.furnaceOnState = furnaceOnState;
    }

    /*
     * Records the current system time in milliseconds as the start time when the furnace is turned on.
     */
    private void setStartMilliseconds() {
        this.startMilliseconds = System.currentTimeMillis();
    }
}

