package stepdefinitions;

import com.itqa.pages.CartPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.MyAccountPage;
import com.itqa.pages.AddressBookPage;
import com.itqa.pages.AddNewAddressPage;
import com.itqa.pages.ProductPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Map;

import static org.testng.Assert.assertEquals;


public class NewAddressSteps{

    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    MyAccountPage myAccountPage = new MyAccountPage(DriverFactory.getDriver());
    AddNewAddressPage addNewAddressPage = new AddNewAddressPage(DriverFactory.getDriver());
    AddressBookPage addressBookPage = new AddressBookPage(DriverFactory.getDriver());


    @When("I click menu toggle")
    public void iClickTheToggle() {HomePage.clickTheToggle();
    }

    @When("I go to the MyAccount")
    public void iGoToTheMyAccountPage() {
        myAccountPage.goToMyAccountPage();
    }

    @When("click address book")
    public void clickAddressBook() {
        myAccountPage.clickAddressBookLink();
    }
    @When("click new address button")
    public void clickedButton() {
        addressBookPage.clickedButton();
    }
    @When("I fill in the following fields:")
    public void iFillInTheFollowingFields(Map<String, String> fields) {
        addNewAddressPage.fillFields(fields); // Fill in the advanced search fields based on the provided map
    }

    @When("I click the Save Address button")
    public void clickButton() {
        addNewAddressPage.clickSaveButton();
    }

    @Then("succeeded message should be {string}")
    public void iShouldSeeTheSuccessMessage(String expectedMessage) {
        assertEquals(expectedMessage, addressBookPage.getSuccessMessage());

}
}
