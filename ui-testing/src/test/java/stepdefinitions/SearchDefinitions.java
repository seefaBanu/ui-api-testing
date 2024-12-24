//package stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//
//public class SearchDefinitions {
//    @When("User enters search term {string} in the search box")
//    public void userEntersSearchTermInTheSearchBox(String searchTerm) {
//        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search']"));
//        searchBox.sendKeys(searchTerm);
//        searchBox.submit();
//    }
//
//    @Then("User should see search results related to {string}")
//    public void userShouldSeeSearchResultsRelatedTo(String searchTerm) {
//        WebElement resultHeader = driver.findElement(By.xpath("//h1[contains(text(),'Search results for')]"));
//        Assert.assertTrue(resultHeader.getText().contains(searchTerm), "Search results are not as expected!");
//    }
//
//    @After
//    public void teardown() {
//        driver.quit();
//    }
//
//}
