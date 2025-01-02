package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements
    private By createAnAccountHref = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a");
    private By fillFirstName = By.xpath("//*[@id='firstname']");
    private By fillLastName = By.xpath("//*[@id='lastname']");
    private By fillEmail = By.xpath("//*[@id=\"email_address\"]");
    private By fillPassword = By.cssSelector("#password");
    private By fillConfirmPassword = By.xpath("//*[@id=\"password-confirmation\"]");
    private By submitButton = By.xpath("//*[@id='form-validate']/div/div[1]/button");

    // Navigate to the Create Account page
    public void goToCreateAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createAnAccountHref))
                .click();
    }

    // Fill in First Name
    public void setFirstName(String firstName) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillFirstName))
                .sendKeys(firstName);
    }

    // Fill in Last Name
    public void setLastName(String lastName) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillLastName))
                .sendKeys(lastName);
    }

    // Fill in Email
    public void setEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillEmail))
                .sendKeys(email);
    }

    // Fill in Password
    public void setPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillPassword))
                .sendKeys(password);
    }

    // Fill in Confirm Password
    public void setConfirmPassword(String confirmPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fillConfirmPassword))
                .sendKeys(confirmPassword);
    }

    // Submit the form
    public void submitForm() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();
    }
}
