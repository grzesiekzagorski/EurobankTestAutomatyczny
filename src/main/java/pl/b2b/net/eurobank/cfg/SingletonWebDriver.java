package pl.b2b.net.eurobank.cfg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {

    private static SingletonWebDriver singletonWebDriverInstance;
    private static WebDriver webDriver;
    private static WebDriverWait wait;

    private SingletonWebDriver(String driverPath) {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, driverPath);
        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public static void initialize(String driverPath) {
        if (singletonWebDriverInstance == null) {
            singletonWebDriverInstance = new SingletonWebDriver(driverPath);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }


    public static void quitWebDriver() {
        webDriver.quit();
        webDriver = null;
        wait = null;
        singletonWebDriverInstance = null;
    }
}

