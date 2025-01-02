package stepdefinitions;

import com.itqa.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends BaseSteps {
    private HomePage homePage;

    public LoginSteps() {
        super();
        homePage = new HomePage(driver);
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        homePage.navigateToHomePage("https://magento.softwaretestingboard.com/");
        homePage.clickSignIn();
    }

    @When("User logs in with username and password")
    public void userLogsInWithUsernameAndPassword() {
        driver.findElement(By.name("login[username]")).sendKeys("testuser123test@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Test@123");
        driver.findElement(By.id("send2")).click();
    }

}
