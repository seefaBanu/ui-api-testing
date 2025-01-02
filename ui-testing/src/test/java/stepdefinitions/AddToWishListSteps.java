package stepdefinitions;
import com.itqa.pages.CartPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.HomePage;
import com.itqa.pages.ProductPage;
import com.itqa.pages.MyWishListPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.*;

import static org.testng.AssertJUnit.assertEquals;


public class AddToWishListSteps {

    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    MyWishListPage  myWishListPage = new MyWishListPage (DriverFactory.getDriver());

    HomePage homePage = new HomePage (DriverFactory.getDriver());

    //MY PART

    @When("I click the Add to Wish List")
    public void i_click_the_add_to_wish_list() {
        productPage.clickAddToWishListLink();
    }

    @When("I select the second product")
    public void iSelectTheSecondProduct() {
        homePage.selectSecondProduct();
    }

    @Then("A success message should be {string}")
    public void succeededMessageShouldBe(String message) {
        assertEquals(message, myWishListPage.getSuccessMessage());
    }

}
