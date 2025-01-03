package com.itqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewBox {

    WebDriver driver;

    public ReviewBox(WebDriver driver) {
        this.driver = driver;
    }

    private By ratingRadioButton(int ratingValue) {
        return By.xpath("//input[@id='Rating_" + ratingValue + "']");
    }
    private By nicknameField = By.id("nickname_field");
    private By summaryField = By.id("summary_field");
    private By reviewField = By.id("review_field");
    private By submitButton = By.cssSelector("button.action.submit.primary");
    private By reviewSuccessMessage = By.cssSelector(".message-success");


    public void selectRating(int stars) {
        WebElement ratingElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(ratingRadioButton(stars)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ratingElement);
        try {
            ratingElement.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ratingElement);
        }
    }

    public void enterNickname(String nickname) {
        driver.findElement(nicknameField).sendKeys(nickname);
    }

    public void enterSummary(String summary) {
        driver.findElement(summaryField).sendKeys(summary);
    }

    public void enterReview(String reviewText) {
        driver.findElement(reviewField).sendKeys(reviewText);
    }

    public void clickSubmitReview() {
        driver.findElement(submitButton).click();
    }

    public boolean isReviewSubmitted() {
        try {
            return driver.findElement(reviewSuccessMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}