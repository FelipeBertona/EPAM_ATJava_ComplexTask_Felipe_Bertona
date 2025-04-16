package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Thread-safe Singleton class for managing WebDriver instances.
 * Each thread will have its own WebDriver instance using ThreadLocal storage,
 * allowing parallel execution of tests.
 * The browser type can be controlled via the 'browser' system property.
 * Supported browsers: Chrome, Firefox, and Edge. Defaults to Chrome if no browser is specified.
 */
public class DriverSingleton {

    /**
     * ThreadLocal to ensure each thread gets its own WebDriver instance.
     */
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private DriverSingleton() {}

    /**
     * Retrieves the ThreadLocal WebDriver instance for the current thread.
     * If no instance exists for the thread, one is created based on the 'browser' system property.
     * Default browser is Chrome.
     *
     * @return WebDriver instance for the current thread.
     */
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String browser = System.getProperty("browser");
            if (browser == null) browser = "chrome";

            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal.set(new FirefoxDriver());
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driverThreadLocal.set(new ChromeDriver());
                    break;
                }
            }
        }
        return driverThreadLocal.get();
    }

    /**
     * Quits the WebDriver instance for the current thread and removes it from ThreadLocal storage.
     */
    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}