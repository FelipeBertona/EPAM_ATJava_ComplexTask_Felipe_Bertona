package hooks;

import driver.WebDriverManagerService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManagerService.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverManagerService.closeDriver();
    }
}