package stepdefinitions;

import com.itqa.pages.*;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompareProductsSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    private ComparePage comparePage = new ComparePage(DriverFactory.getDriver());
    private SearchResultPage searchResultPage = new SearchResultPage(DriverFactory.getDriver());
    private WebDriver driver = DriverFactory.getDriver();


    @Given("I am on the homepage for comparison")
    public void iAmOnTheHomepageForComparison() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I search for {string} for comparison")
    public void iSearchForComparison(String productName) {
        homePage.searchProduct(productName);
    }

    @When("I select the {string} product for comparison")
    public void iSelectTheFirstProduct(String index) {
        if (index.equals("first"))
             searchResultPage.selectProduct(0);
        else if (index.equals("second")) {
            searchResultPage.selectProduct(1);
        }
    }


    @When("I click the \"Add to Compare\" link")
    public void iClickTheAddToCompareLink() {
        productPage.clickAddToCompare();
    }

    @Then("I should see a success message indicating that product was added to compare list")
    public void iShouldSeeASuccessMessageIndicatingThatProductWasAddedToCompareList() {
        Assert.assertTrue(productPage.getCompareListSuccessMessage().contains("You added product"));
    }

    @Then("the product should be added to the compare products list and count {int}")
    public void theProductShouldBeAddedToTheCompareProductsListAndCount(int count) {
        Assert.assertEquals(searchResultPage.getCompareCount(), count);
    }
    @When("I select the second product for comparison")
    public void iSelectTheSecondProduct() {
        driver.navigate().back(); // Go back to the search results
        searchResultPage.selectProduct(1);
    }

    @When("I click the compare button")
    public void iClickTheCompareButton() {
        homePage.goToComparePage();
    }


    @Then("I should see  the comparison list")
    public void iShouldSeeTheComparisonList() {
        Assert.assertTrue((Boolean) comparePage.isComparePageVisible());
    }


    @After()
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}