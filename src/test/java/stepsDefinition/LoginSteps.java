package stepsDefinition;

import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.AbstractPage;
import page.InventoryPage;
import page.LoginPage;
import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {

    private final WebDriver driver = DriverSingleton.getDriver();
    private LoginPage loginPage;
    private AbstractPage resultPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Given("I navigate to {string}")
    public void NavigateTo(String url){
        logger.info("Executing step: I navigate to '{}'", url);
        this.loginPage = new LoginPage(driver);
        this.loginPage.openPage();
        logger.info("Successfully navigated to '{}'", url);
    }

    @When("I enter {string} into the username field")
    public void EnterUsername(String username){
        logger.info("Executing step: I enter '{}' into the username field", username);
        this.loginPage.enterUsername(username);
        logger.info("Username '{}' entered successfully", username);
    }

    @When("I enter {string} into the password field")
    public void EnterPassword(String password){
        logger.info("Executing step: I enter a password (hidden for security)");
        this.loginPage.enterPassword(password);
        logger.info("Password entered successfully");
    }

    @When("I clear both the username and password fields")
    public void ClearBothFields(){
        logger.info("Executing step: I clear the username and password fields");
        this.loginPage.clearUsername();
        this.loginPage.clearPassword();
        logger.info("Username and password fields cleared successfully");
    }

    @When("I clear the password field")
    public void ClearPasswordField(){
        logger.info("Executing step: I clear the password field");
        this.loginPage.clearPassword();
        logger.info("Password field cleared successfully");
    }

    @When("I click the login button")
    public void ClickLoginButton(){
        logger.info("Executing step: I click the login button");
        logger.info("Login button clicked");
        this.resultPage = this.loginPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void ShouldSeeErrorMessage(String expectedMessage){
        logger.info("Executing step: I should see the error message '{}'", expectedMessage);

        try {
            assertThat(resultPage).isInstanceOf(LoginPage.class);
        }
        catch (Exception e){
            logger.error("Assertion failed in step: I should see the title '{}'"
                    + "The page wasn't LoginPage", expectedMessage);
            throw e;
        }

        try {
            String actualMessage = ((LoginPage) resultPage).getErrorMessage();
            logger.info("Validating error message: Expected '{}', Actual '{}'", expectedMessage, actualMessage);
            assertThat(actualMessage).isEqualTo(expectedMessage);

        } catch (AssertionError e){
            logger.error("Assertion failed in step: I should see the error message. "
                    + "Expected '{}', but got '{}'.", expectedMessage, ((LoginPage) resultPage).getErrorMessage());
            throw e;
        }
    }

    @Then("I should see the title {string}")
    public void ShouldSeeTitle(String expectedTitle) {
        logger.info("Executing step: I should see the title '{}'", expectedTitle);

        try {
            assertThat(resultPage).isInstanceOf(InventoryPage.class);
        }
        catch (AssertionError e){
            logger.error("Assertion failed in step: I should see the title '{}'"
                    + "The page wasn't InventoryPage", expectedTitle);
            throw e;
        }

        try {
            String actualTitle = ((InventoryPage) resultPage).getTitle();
            logger.info("Validating title: Expected '{}', Actual '{}'", expectedTitle, actualTitle);
            assertThat(actualTitle).isEqualTo(expectedTitle);
        } catch (AssertionError e) {
            logger.error("Assertion failed in step: I should see the title. "
                    + "Expected '{}', but got '{}'. Error: {}", expectedTitle, ((InventoryPage) resultPage).getTitle(), e.getMessage());
            throw e;
        }
    }
}
