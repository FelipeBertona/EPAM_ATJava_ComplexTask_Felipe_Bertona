package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.BasePage;
import page.InventoryPage;
import page.LoginPage;
import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {

    private LoginPage loginPage;
    private BasePage resultPage;
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Given("I navigate to {string}")
    public void NavigateTo(String url){
        logger.info("Executing step: I navigate to '{}'", url);
        this.loginPage = new LoginPage();
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
        assertThat(resultPage)
                .withFailMessage("Assertion failed in step: I should see the title '%s'. "
                        + "The page wasn't LoginPage", expectedMessage)
                .isInstanceOf(LoginPage.class);

        String actualMessage = ((LoginPage) resultPage).getErrorMessage();
        logger.info("Validating error message: Expected '{}', Actual '{}'", expectedMessage, actualMessage);
        assertThat(actualMessage)
                .withFailMessage("Assertion failed in step: I should see the error message. "
                        + "Expected '%s', but got '%s'.", expectedMessage, actualMessage)
                .isEqualTo(expectedMessage);
    }

    @Then("I should see the title {string}")
    public void ShouldSeeTitle(String expectedTitle) {
        logger.info("Executing step: I should see the title '{}'", expectedTitle);
        assertThat(resultPage)
                .withFailMessage("Assertion failed in step: I should see the title '%s'. "
                        + "The page wasn't InventoryPage", expectedTitle)
                .isInstanceOf(InventoryPage.class);

        String actualTitle = ((InventoryPage) resultPage).getTitle();
        logger.info("Validating title: Expected '{}', Actual '{}'", expectedTitle, actualTitle);
        assertThat(actualTitle)
                .withFailMessage("Assertion failed in step: I should see the title. "
                        + "Expected '%s', but got '%s'.", expectedTitle, actualTitle)
                .isEqualTo(expectedTitle);
    }
}
