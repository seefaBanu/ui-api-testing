
package stepdefinitions;

import com.itqa.pages.CatalogAdvancedSearchPage;
import com.itqa.pages.HomePage;
import com.itqa.pages.AdvancedSearchPage;
import com.itqa.pages.CatalogAdvancedSearchPage;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.*;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;


public class AdvancedSearchSteps {
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(DriverFactory.getDriver());  // Make sure this is initialized properly
    CatalogAdvancedSearchPage catalogAdvancedSearchPage = new CatalogAdvancedSearchPage(DriverFactory.getDriver());


    @When("I go to the Advanced Search Page")
    public void iGoToTheAdvancedSearchPage() {
        advancedSearchPage.goToAdvancedSearchPage();
    }

    @When("I fill in the following fields:")
    public void iFillInTheFollowingFields(Map<String, String> fields) {
        advancedSearchPage.fillFields(fields); // Fill in the advanced search fields based on the provided map
    }

    @When("I click the Search button")
    public void clickButton() {
        advancedSearchPage.clickButton();
    }

    @Then("succeeded message should be {string}")
    public void iShouldSeeTheSuccessMessage(String expectedMessage) {
        assertEquals(expectedMessage, catalogAdvancedSearchPage.getSuccessMessage());
    }

}

