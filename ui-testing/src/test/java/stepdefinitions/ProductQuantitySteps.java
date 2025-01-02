//package stepdefinitions;
//
//import com.itqa.pages.CartPage;
//import com.itqa.pages.HomePage;
//import com.itqa.pages.ProductPage;
//import com.itqa.utils.DriverFactory;
//import io.cucumber.java.en.*;
//import static org.testng.AssertJUnit.assertEquals;
//
//public class ProductQuantitySteps {
//    HomePage homePage = new HomePage(DriverFactory.getDriver());
//    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
//    CartPage cartPage = new CartPage(DriverFactory.getDriver());
//
////    @Given("I am on the homepage")
////    public void iAmOnTheHomepage() {
////        DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
////    }
//
////    @When("I search for {string}")
////    public void iSearchFor(String productName) {
////        homePage.searchProduct(productName);
////    }
//
//    @When("I select the product")
//    public void iSelectTheProduct() {
//        homePage.selectFirstProduct();
//    }
//
//    @When("I set the quantity to {int}")
//    public void iSetTheQuantityTo(int quantity) {
//        productPage.setProductQuantity(quantity);
//    }
//
////    @When("I click {string}")
////    public void iClick(String button) {
////        if (button.equals("Add to Cart")) {
////            productPage.addToCart();
////        }
////    }
//
//    @Then("the error message {string} should be displayed")
//    public void theErrorMessageShouldBeDisplayed(String expectedMessage) {
//        String actualMessage = productPage.getErrorMessage();
//        assertEquals(expectedMessage, actualMessage);
//    }
//
//    @Then("the cart should not be updated with the product")
//    public void theCartShouldNotBeUpdatedWithTheProduct() {
//        String cartItemCount = homePage.getCartItemCount();
//        assertEquals("0", cartItemCount);  // Assumes the cart was initially empty
//    }
//}
