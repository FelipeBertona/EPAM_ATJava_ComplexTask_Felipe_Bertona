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
 * Login Page of the SauceDemo application.
 * Handles authentication and validation of login errors.
 */
public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElement errorMessage;

    public LoginPage() {
        super();
        PageFactory.initElements(this.driver, this);
        logger.info("LoginPage initialized");
    }

    @Override
    public LoginPage openPage() {
        logger.info("Navigating to URL: " + BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password: {}", password);
        inputPassword.sendKeys(password);
    }

    public void clearUsername() {
        logger.info("Clearing the username field");
        inputUsername.sendKeys(Keys.CONTROL + "a");
        inputUsername.sendKeys(Keys.DELETE);
    }

    public void clearPassword() {
        logger.info("Clearing the password field");
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.DELETE);
    }

    public void clickLoginButton() {
        new WebDriverWait(this.driver, Duration.of(this.WAIT_TIMEOUT_SECONDS, ChronoUnit.SECONDS))
                .until(ExpectedConditions.elementToBeClickable(loginButton));

        loginButton.click();
    }

    public String getErrorMessage() {
        String error = errorMessage.getText();
        logger.info("Captured error message: {}", error);
        return error;
    }
}