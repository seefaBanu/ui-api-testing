package stepdefinitions;

import com.itqa.pages.OrdersAndReturnsPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class OrdersAndReturnsSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private OrdersAndReturnsPage ordersAndReturnsPage = new OrdersAndReturnsPage(DriverFactory.getDriver());


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
        Assert.assertEquals(driver.getTitle(), "Orders and Returns");
    }

    @When("I enter {string} into the {string} field")
    public void iEnterIntoTheField(String text, String fieldLabel) {
        ordersAndReturnsPage.enterField(fieldLabel, text);
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
    }

    @Then("I should see the order details page")
    public void iShouldSeeTheOrderDetailsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("sales/guest/view/"));
    }

    @Then("Order details should be shown for order id {string}")
    public void getOrderId(String orderId) {
        Assert.assertEquals(ordersAndReturnsPage.getOrderIdOnPage(),orderId);
    }

    @After()
    public void tearDown(){
        DriverFactory.closeDriver(); // close driver at the end of each scenario.
    }
}