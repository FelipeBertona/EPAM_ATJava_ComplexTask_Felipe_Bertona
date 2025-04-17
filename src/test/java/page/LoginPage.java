package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Page object representing the Login Page of the SauceDemo application.
 * Provides methods to interact with and verify the functionality of the login form.
 */
public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    /**
     * Web element representing the username input field.
     */
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUsername;

    /**
     * Web element representing the password input field.
     */
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    /**
     * Web element representing the login button.
     */
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    /**
     * Web element representing the error message container for login errors.
     */
    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElement errorMessage;

    /**
     * Constructs a LoginPage object and initializes its elements.
     */
    public LoginPage() {
        super();
        PageFactory.initElements(this.driver, this);
        logger.info("LoginPage initialized");
    }

    /**
     * Opens the Login Page.
     *
     * @return Current LoginPage instance.
     */
    @Override
    public LoginPage openPage() {
        logger.info("Navigating to URL: " + BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    /**
     * Enters the specified username into the username field.
     *
     * @param username The username to be entered.
     */
    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        inputUsername.sendKeys(username);
    }

    /**
     * Enters the specified password into the password field.
     *
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        logger.info("Entering password: {}", password);
        inputPassword.sendKeys(password);
    }

    /**
     * Clears the username field by selecting and deleting its content.
     */
    public void clearUsername() {
        logger.info("Clearing the username field");
        inputUsername.sendKeys(Keys.CONTROL + "a");
        inputUsername.sendKeys(Keys.DELETE);
    }

    /**
     * Clears the password field by selecting and deleting its content.
     */
    public void clearPassword() {
        logger.info("Clearing the password field");
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.DELETE);
    }

    /**
     * Clicks the login button to attempt login.
     * Returns an InventoryPage instance if login is successful, otherwise returns the current LoginPage instance.
     *
     * @return An AbstractPage representing the next page.
     */
    public BasePage clickLoginButton() {
        loginButton.click();
        try {
            logger.info("Trying to login...");
            new WebDriverWait(this.driver, Duration.of(this.WAIT_TIMEOUT_SECONDS, ChronoUnit.SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='app_logo']")));
            logger.info("Login successful");
            return new InventoryPage();
        } catch (TimeoutException te) {
            logger.warn("Login failed");
            return this;
        }
    }

    /**
     * Retrieves the error message displayed in the error message container.
     *
     * @return A string representing the captured error message.
     */
    public String getErrorMessage() {
        String error = errorMessage.getText();
        logger.info("Captured error message: {}", error);
        return error;
    }
}