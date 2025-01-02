package stepdefinitions;

import com.itqa.pages.AddressBookPage;
import com.itqa.pages.CartPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.MyAccountPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver before each scenario
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // Quit the WebDriver after each scenario
        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("Cleaning up test data...");

        // Remove all products from the cart
//        try {
//            CartPage cartPage = new CartPage(DriverFactory.getDriver());
//            cartPage.goToCartPage();
//            while (cartPage.getCartItemCount() > 0) {
//                cartPage.removeItemFromCart();
//                cartPage.deleteConfirmationPopup();
//            }
//            System.out.println("All products removed from the cart.");
//        } catch (Exception e) {
//            System.err.println("Error removing products from the cart: " + e.getMessage());
//        }

        // Remove all addresses
        try {
            LoginSteps loginSteps = new LoginSteps();
            loginSteps.userIsOnTheLoginPage();
            loginSteps.userLogsInWithUsernameAndPassword();
            HomePage homePage = new HomePage(DriverFactory.getDriver());
            homePage.clickTheToggle();
            MyAccountPage myAccountPage = new MyAccountPage(DriverFactory.getDriver());
            AddressBookPage addressBookPage = new AddressBookPage(DriverFactory.getDriver());

            myAccountPage.goToMyAccountPage();
            myAccountPage.clickAddressBookLink();

            addressBookPage.removeAllAddresses();
            System.out.println("All addresses removed.");
        } catch (Exception e) {
            System.err.println("Error removing addresses: " + e.getMessage());
        }
    }
}