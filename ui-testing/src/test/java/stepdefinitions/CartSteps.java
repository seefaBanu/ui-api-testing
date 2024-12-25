package stepdefinitions;

import com.itqa.pages.CartPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.ProductPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.*;

import static org.testng.AssertJUnit.assertEquals;

public class CartSteps {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
    }

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
    }

    @Then("the cart should show {string} item")
    public void theCartShouldShowItem(String count) {
        assertEquals(count, homePage.getCartItemCount());
    }

    @Then("success message should be {string}")
    public void successMessageShouldBe(String message) {
        assertEquals(message, productPage.getSuccessMessage());
    }

    @Given("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        iAmOnTheHomepage();
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

}
