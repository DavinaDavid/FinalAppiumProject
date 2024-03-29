package utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class appiumDriverFactory {
    private static appiumDriverFactory instanceOfAppiumDriverFactory = null;
    private AppiumDriver<AndroidElement> driver;


    private static String appPackage = configFileReader.getConfigPropertyVal("appPackage");
    private static String appActivity = configFileReader.getConfigPropertyVal("appActivity");
    private static String deviceName = configFileReader.getConfigPropertyVal("deviceName");


    // Declaring constructor as private to restrict object creation outside of class
    private appiumDriverFactory() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("device", deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("noReset", "true");
        //capabilities.setCapability("unicodeKeyboard", true);
        //AppiumDriver driver;

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);

    }

    public static appiumDriverFactory getInstanceOfAppiumDriverFactory() {
        if (instanceOfAppiumDriverFactory == null)
            instanceOfAppiumDriverFactory = new appiumDriverFactory();

        return instanceOfAppiumDriverFactory;
    }

    // To get driver
    public AppiumDriver<AndroidElement> getDriver() {

        return driver;
    }
}
