package page;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Base abstract class for all page objects.
 * Provides shared WebDriver management and defines contract for page navigation.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 3;
    protected final String BASE_URL = "https://www.saucedemo.com/";

    protected BasePage() {
        this.driver = WebDriverManager.getDriver();
    }

    /**
     * Opens the specific page implementation.
     * @return instance of the page
     */
    protected abstract BasePage openPage();
}