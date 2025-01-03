package stepdefinitions;

import com.itqa.pages.CartPage;
import com.itqa.pages.CheckoutPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.ProductPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.*;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutSteps {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());

    @When("I navigate to the shopping cart page")
    public void iNavigateToTheShoppingCartPage() {
        cartPage.goToCartPage();
    }

    @When("I click on the Proceed to Checkout button")
    public void iClickOnTheButton() {
            cartPage.clickProceedToCheckout();
    }

    @Then("I should be redirected to the checkout page")
    public void iShouldBeRedirectedToTheCheckoutPage() {
        assertEquals("Shipping Address", checkoutPage.getPageTitle());
    }

    @Then("I should click next and redirected to payment page")
    public void iShouldBeRedirectedToPaymentPage() {
        checkoutPage.clickNextToPaymentPage();
        assertEquals("Payment Method", checkoutPage.getPaymentPageTitle());
    }

    @When("I click place order")
    public void iClickPlaceOrder() {
        checkoutPage.placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        assertEquals("Checkout", checkoutPage.getOrderConfirmationMessage());
    }
}


