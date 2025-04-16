package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/login_UC3.feature",
        glue = {"stepsDefinition", "hooks"},
        plugin = {"pretty", "html:target/HTMLReports/UC3_report.html"})
public class TestRunnerUC3 { }
