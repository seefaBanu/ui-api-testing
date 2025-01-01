package stepdefinitions;

import com.itqa.pages.CartPage;
import com.itqa.pages.ComparePage;
import com.itqa.pages.HomePage;
import com.itqa.pages.OrdersAndReturnsPage;
import com.itqa.pages.ProductPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AllSteps {


    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private OrdersAndReturnsPage ordersAndReturnsPage = new OrdersAndReturnsPage(DriverFactory.getDriver());
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    private CartPage cartPage = new CartPage(DriverFactory.getDriver());
    private ComparePage comparePage = new ComparePage(DriverFactory.getDriver());
    private WebDriver driver = DriverFactory.getDriver();



    // Steps from Orders and Returns functionality
    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
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
        Assert.assertEquals(message, "We can't find an order with the specified information.");

    }
    // steps from cart functionality

    @When("I search for {string}")
    public void iSearchFor(String productName) {
        homePage.searchProduct(productName);
    }

    @When("I select the first product")
    public void iSelectTheFirstProduct() {
        homePage.selectFirstProduct();
    }

    @When("I select size {string} and color {string}")
    public void iSelectSizeAndColor(String size, String color) {
        productPage.selectSize(size);
        productPage.selectColor(color);
    }

    @When("I click {string}")
    public void iClick(String button) {
        if (button.equals("Add to Cart")) {
            productPage.addToCart();
        }
        else if(button.equals("Add to Compare")){
            productPage.addToCompare();
        }
    }

    @Then("the cart should show {string} item")
    public void theCartShouldShowItem(String count) {
        Assert.assertEquals(count, homePage.getCartItemCount());
    }

    @Then("success message should be {string}")
    public void successMessageShouldBe(String message) {
        Assert.assertEquals(message, productPage.getSuccessMessage());
    }

    @Given("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        iAmOnTheHomePage();
        iSearchFor("T-Shirt");
        iSelectTheFirstProduct();
        iSelectSizeAndColor("M","Blue");
        iClick("Add to Cart");
    }

    @When("I go to the cart page")
    public void iGoToTheCartPage() {
        cartPage.goToCartPage();
    }

    @When("I click Remove for the product")
    public void iClickRemoveForTheProduct() {
        cartPage.removeItemFromCart();
    }


    @Then("I click OK on confirmation popup")
    public void iClickOKOnTheConfirmationPopup() {
        cartPage.deleteConfirmationPopup();
    }
    // steps from compare functionality

    @When("I navigate to the product detail page")
    public void iNavigateToTheProductDetailPage() {
        driver.navigate().back();
    }
    @Then("I should see a success message indicating that product was added to compare list")
    public void iShouldSeeASuccessMessageIndicatingThatProductWasAddedToCompareList() {
        Assert.assertTrue(productPage.getSuccessMessage().contains("You added product"));

    }
    @Then("the product should be added to the compare products list")
    public void theProductShouldBeAddedToTheCompareProductsList() {
        Assert.assertEquals(homePage.getCompareCount(), "1");
    }
    @When("I go to the compare product page")
    public void iGoToTheCompareProductPage() {
        homePage.goToComparePage();
    }
    @Then("I should see {string} products in the comparison list")
    public void iShouldSeeProductsInTheComparisonList(String count) {
        Assert.assertEquals(comparePage.getCompareItemCount(), count);
    }
    // =================
    // Cleanup
    // =================

    @After()
    public void tearDown(){
        DriverFactory.closeDriver(); // close driver at the end of each scenario.
    }

}