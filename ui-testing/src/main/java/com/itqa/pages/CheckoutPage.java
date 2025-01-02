package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By pageTitle = By.xpath("//*[@id=\"shipping\"]/div[1]");
    private By nextToPaymentButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
    private By paymentPageTitle = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    private By placeOrderButton = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");

    private By orderConfirmationMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    // Methods
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void clickNextToPaymentPage() {
        driver.findElement(nextToPaymentButton).click();
    }

    public String getPaymentPageTitle() {
        return driver.findElement(paymentPageTitle).getText();
    }

    public void placeOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public String getOrderConfirmationMessage() {
        return driver.findElement(orderConfirmationMessage).getText();
    }


}
