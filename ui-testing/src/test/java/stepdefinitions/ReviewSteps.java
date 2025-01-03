package stepdefinitions;

import com.itqa.pages.ProductPage;
import com.itqa.pages.ReviewBox;
import com.itqa.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewSteps {
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    ReviewBox reviewBox = new ReviewBox(DriverFactory.getDriver());

    @And("User clicks on the {string} button")
    public void userClicksOnButton(String buttonText) {
        productPage.clickAddReviewButton();
    }

    @And("User fills out the review form with nickname {string}, summary {string}, and review text {string}")
    public void userFillsOutReviewForm(String nickname, String summary, String reviewText) {
        reviewBox.selectRating(2);
        reviewBox.enterNickname(nickname);
        reviewBox.enterSummary(summary);
        reviewBox.enterReview(reviewText);
    }

    @And("User submits the review")
    public void userSubmitsTheReview() {
        reviewBox.clickSubmitReview();
    }

    @Then("The review is successfully submitted and a success message is displayed")
    public void reviewSuccessMessage() {
        assert reviewBox.isReviewSubmitted();
        System.out.println("Review submitted successfully!");
    }

}