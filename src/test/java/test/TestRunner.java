package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepsDefinition", "hooks"},
        plugin = {"pretty",
                  "html:target/HTMLReports/report.html",
                  "json:target/JSONReports/report.json",
                  "junit:target/XMLReports/report.xml"})
public class TestRunner {

}
