package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By pageTitle = By.xpath("//*[@id=\"shipping\"]/div[1]");
    private By nextToPaymentButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
    private By paymentPageTitle = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    private By placeOrderButton = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");

    private By orderConfirmationMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    // Methods
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void clickNextToPaymentPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(nextToPaymentButton))
                .click();
    }

    public String getPaymentPageTitle() {
        return driver.findElement(paymentPageTitle).getText();
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-billing-address")));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(placeOrderButton))
                .click();
    }

    public String getOrderConfirmationMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage))
                .getText();
    }


}

