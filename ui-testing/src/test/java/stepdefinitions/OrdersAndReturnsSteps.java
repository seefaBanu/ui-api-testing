import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;


public class OrdersAndReturnsSteps {

    private WebDriver driver;



    public OrdersAndReturnsSteps() {
        System.setProperty("webdriver.chrome.driver", "https://magento.softwaretestingboard.com/");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        driver.get("https://magento.softwaretestingboard.com");
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("I should be redirected to the Orders and Returns page")
    public void iShouldBeRedirectedToTheOrdersAndReturnsPage() {
        Assert.assertEquals(driver.getTitle(), "Orders and Returns");
    }

    @Given("I am on the Orders and Returns page")
    public void iAmOnTheOrdersAndReturnsPage() {
        driver.get("https://magento.softwaretestingboard.com/sales/guest/form/");
        Assert.assertEquals(driver.getTitle(),"Orders and Returns");
    }

    @When("I enter {string} into the {string} field")
    public void iEnterIntoTheField(String text, String fieldLabel) {
        switch (fieldLabel){
            case "Order ID" :
                driver.findElement(By.id("order-id")).sendKeys(text);
                break;
            case "Billing Last Name" :
                driver.findElement(By.id("billing-lastname")).sendKeys(text);
                break;
            case "Email" :
                driver.findElement(By.id("guest-email")).sendKeys(text);
        }

    }

    @When("I select {string} as the search method")
    public void iSelectAsTheSearchMethod(String searchMethod) {
        WebElement selectElement = driver.findElement(By.id("order-search"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(searchMethod);
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
    }

    @Then("I should see the order details page")
    public void iShouldSeeTheOrderDetailsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("sales/guest/view/"));

    }


    @Then("I should see an error message indicating that {string} is a required field")
    public void iShouldSeeAnErrorMessageIndicatingThatIsARequiredField(String field) {
        WebElement errorMessage = driver.findElement(By.id("order-id-error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        String message = errorMessage.getText();
        Assert.assertEquals(message, "This is a required field.");

    }


    @Then("I should see a message indicating that no order was found with the provided information")
    public void iShouldSeeAMessageIndicatingThatNoOrderWasFoundWithTheProvidedInformation() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".message-error.error.message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        String message = errorMessage.getText();
        Assert.assertEquals(message,"We can't find an order with the specified information.");

    }

    @After()
    public void tearDown(){
        if(driver !=null) {
            driver.quit();
        }

    }
}