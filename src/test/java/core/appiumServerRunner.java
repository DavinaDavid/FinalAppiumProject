package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

public class appiumServerRunner {
    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities myCapabilities;

    public static void startServer(int port) {
        myCapabilities = new DesiredCapabilities();
        myCapabilities.setCapability("noReset", "false");
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(port);
        builder.withCapabilities(myCapabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopServer() {
        service.stop();
    }
    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void StartAppiumServer(String port) {
        System.out.println("Checking Appium Server");
        System.out.println("PORT" + port);

        if (!checkIfServerIsRunnning(Integer.parseInt(port))) {
            System.out.println("Starting an Appium Server");
            startServer(Integer.parseInt(port));
        }
    }
}
