package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
