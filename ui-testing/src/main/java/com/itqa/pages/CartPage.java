package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By removeButton = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a");
    private By cartLink = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By okButton = By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[2]");
    private By cartItemCount = By.cssSelector(".minicart-wrapper .counter-number");
    private By viewAndEditCart = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a");
    private By editItem = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[1]/a");

    private By proceedToCheckoutButton = By.cssSelector("#top-cart-btn-checkout");

    public void clickProceedToCheckout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton))
                .click();
    }

    public void removeItemFromCart() {
        driver.findElement(removeButton).click();
    }

    public void goToCartPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[2]/header/div[2]/div[1]/a/span[2]\n")));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(cartLink))
                .click();
    }

    public void deleteConfirmationPopup(){

        driver.findElement(okButton).click();
    }

    public int getCartItemCount() {
        String count = driver.findElement(cartItemCount).getText();
        return Integer.parseInt(count);
    }

    public void goToViewAndEditCartPage(){
        driver.findElement(viewAndEditCart).click();
    }

    public void editAddedItem(String productName) {
        // Dynamically locate the product name in the mini cart
        String productNameXpath = String.format("//*[@id='mini-cart']//li/div/div/strong/a[text()='%s']", productName);

        // Locate the specific product link element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productNameXpath)));

        // Ensure the edit button related to the product is clickable
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(editItem));

        // Click the edit button
        editButton.click();
    }

}