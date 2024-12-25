//package stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import java.time.Duration;
//
//public class LoginSteps {
//    private static WebDriver driver;
//    public final static int TIMEOUT = 10;
//
//    @Before
//    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
//    }
//
//    @Given("User is on HRMLogin page {string}")
//    public void loginTest(String url) {
//
//        driver.get(url);
//
//    }
//
//    @When("User enters username as {string} and password as {string}")
//    public void goToHomePage(String userName, String passWord) {
//
//        // login to application
//        driver.findElement(By.name("login[username]")).sendKeys(userName);
//        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(passWord);
//        driver.findElement(By.xpath("//*[@id=\"send2\"]")).submit();
//
//    }
//
//    @Then("User should be able to login sucessfully and new page open")
//    public void userShouldBeAbleToLoginSucessfullyAndNewPageOpen() {
//
//        String homePageHeading = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
//
//        //Verify new page - HomePage
//        Assert.assertEquals(homePageHeading, "Home Page");
//    }
//
//    @Then("User should be able to see error message {string}")
//    public void verifyErrorMessage(String expectedErrorMessage) {
//
//        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
//
//        // Verify Error Message
//        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
//
//        driver.quit();
//
//    }
//
//    @After
//    public void teardown() {
//        driver.quit();
//    }
//
//}