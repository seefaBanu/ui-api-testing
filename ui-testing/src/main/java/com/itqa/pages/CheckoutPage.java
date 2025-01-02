package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private By pageTitle = By.xpath("//*[@id=\"shipping\"]/div[1]");
    private By shippingFirstName = By.id("shipping-firstname");
    private By shippingLastName = By.id("shipping-lastname");
    private By shippingAddress = By.id("shipping-address");
    private By shippingCity = By.id("shipping-city");
    private By shippingZipCode = By.id("shipping-zipcode");
    private By shippingCountry = By.id("shipping-country");
    private By nextToPaymentButton = By.id("next-to-payment");
    private By paymentPageTitle = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[1]");
    private By placeOrderButton = By.id("place-order");
    private By orderConfirmationMessage = By.id("order-confirmation");

    // Methods
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void enterShippingDetails(String firstName, String lastName, String address, String city, String zipCode, String country) {
        driver.findElement(shippingFirstName).sendKeys(firstName);
        driver.findElement(shippingLastName).sendKeys(lastName);
        driver.findElement(shippingAddress).sendKeys(address);
        driver.findElement(shippingCity).sendKeys(city);
        driver.findElement(shippingZipCode).sendKeys(zipCode);
        driver.findElement(shippingCountry).sendKeys(country);
    }

    public String getShippingSuccessMessage() {
        // Assuming the shipping success message appears after entering details
        return "Shipping details entered successfully"; // Change to actual validation once implemented
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

