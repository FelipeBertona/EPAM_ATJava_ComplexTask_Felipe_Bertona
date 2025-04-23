package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Singleton class for managing a single WebDriver instance.
 * The browser type can be controlled via the 'browser' system property.
 * Supported browsers: Chrome, Firefox, and Edge. Defaults to Chrome if no browser is specified.
 */
public class WebDriverManagerService {
    private static WebDriver driver;

    /**
     * Private constructor to prevent instantiation of this singleton class.
     */
    private WebDriverManagerService() {}

    /**
     * Retrieves the instance of the WebDriver.
     * If no instance exists, one is created based on the 'browser' system property.
     * Default browser is Chrome.
     *
     * @return the WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");
            if (browser == null) browser = "chrome";

            switch (browser) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
        }
        return driver;
    }

    /**
     * Closes and quits the WebDriver instance if it exists.
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}