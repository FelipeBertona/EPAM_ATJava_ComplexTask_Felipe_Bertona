package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Singleton class for managing a single WebDriver instance.
 * The browser type can be controlled via the 'browser' system property.
 * Supported browsers: Chrome, Firefox, and Edge. Defaults to Chrome if no browser is specified.
 */
public class WebDriverManager {
    private static WebDriver driver;

    /**
     * Private constructor to prevent instantiation of this singleton class.
     */
    private WebDriverManager() {}

    /**
     * Retrieves the instance of the WebDriver.
     * If no instance exists, one is created based on the 'browser' system property.
     * Default browser is Chrome.
     *
     * @return the WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            // Get the desired browser type from system properties
            String browser = System.getProperty("browser");
            if (browser == null) browser = "chrome"; // Default to Chrome if browser is not specified

            // Initialize the WebDriver based on the browser type
            switch (browser) {
                case "firefox": {
                    io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(); // Initialize Firefox WebDriver
                    break;
                }
                case "edge": {
                    io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(); // Initialize Edge WebDriver
                    break;
                }
                default: {
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(); // Default to Chrome WebDriver
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
            driver.quit(); // Quit the WebDriver session
            driver = null; // Reset the WebDriver instance
        }
    }
}