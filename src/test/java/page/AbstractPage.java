package page;

import org.openqa.selenium.WebDriver;

/**
 * Represents an abstract base class for all page objects in the automation framework.
 * Provides a shared implementation for managing the WebDriver instance and enforcing
 * the contract for opening pages.
 * <p>
 * Subclasses must implement the {@link #openPage()} method to define behavior
 * for navigating to specific pages.
 */
public abstract class AbstractPage {

    /**
     * The WebDriver instance used by the page object to interact with the browser.
     */
    protected WebDriver driver;

    /**
     * Defines the timeout duration (in seconds) for waiting on elements or operations.
     */
    protected final int WAIT_TIMEOUT_SECONDS = 3;

    /**
     * Constructs a new AbstractPage with the provided WebDriver instance.
     *
     * @param driver the WebDriver instance to be used by the page object
     */
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abstract method that enforces the contract for opening a page.
     *
     * @return an instance of the specific implementation class (subclass of AbstractPage)
     */
    protected abstract AbstractPage openPage();

}