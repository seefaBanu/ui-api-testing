package stepdefinitions;

import com.itqa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each scenario
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // Quit the WebDriver after each scenario
        DriverFactory.quitDriver();
    }
}
