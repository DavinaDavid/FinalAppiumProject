package utils;

import core.appiumDriver;

public class androidUtils {
    private appiumDriver driver;

    public androidUtils(appiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Function to pause the execution for the specified time period
     *
     * @param milliSeconds The wait time in milliseconds
     */
    public void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
