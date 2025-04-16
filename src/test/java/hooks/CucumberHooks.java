package hooks;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        DriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}