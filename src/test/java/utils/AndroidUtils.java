package utils;

import io.appium.java_client.AppiumDriver;

public class AndroidUtils {
    private AppiumDriver driver; // Corrected class name

    public AndroidUtils(AppiumDriver driver) { // Corrected constructor name
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
