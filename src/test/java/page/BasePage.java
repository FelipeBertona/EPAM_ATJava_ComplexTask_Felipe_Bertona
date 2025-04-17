package page;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Represents an abstract base class for all page objects in the automation framework.
 * Provides a shared implementation for managing the WebDriver instance and enforcing
 * the contract for opening pages.
 * <p>
 * Subclasses must implement the {@link #openPage()} method to define behavior
 * for navigating to specific pages.
 */
public abstract class BasePage {

    /**
     * The WebDriver instance used by the page object to interact with the browser.
     */
    protected WebDriver driver;

    /**
     * Defines the timeout duration (in seconds) for waiting on elements or operations.
     */
    protected final int WAIT_TIMEOUT_SECONDS = 3;

    /**
     * Base URL of the WebPage.
     */
    protected final String BASE_URL = "https://www.saucedemo.com/";

    /**
     * Constructs a new AbstractPage with the provided WebDriver instance.
     *
     */
    protected BasePage() {
        this.driver = WebDriverManager.getDriver();
    }

    /**
     * Abstract method that enforces the contract for opening a page.
     *
     * @return an instance of the specific implementation class (subclass of AbstractPage)
     */
    protected abstract BasePage openPage();

}