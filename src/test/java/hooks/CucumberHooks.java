package hooks;

import driver.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}