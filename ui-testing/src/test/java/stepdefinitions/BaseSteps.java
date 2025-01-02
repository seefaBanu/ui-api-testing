package stepdefinitions;

import com.itqa.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps() {
        this.driver = DriverFactory.getDriver();
    }
}