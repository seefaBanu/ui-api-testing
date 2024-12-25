package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    private By removeButton = By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a");
    private By cartLink = By.cssSelector(".minicart-wrapper .action.showcart");
    private By okButton = By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[2]");
    private By cartItemCount = By.cssSelector(".minicart-wrapper .counter-number");
    private By viewAndEditCart = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void removeItemFromCart() {
        driver.findElement(removeButton).click();
    }

    public void goToCartPage() {
        driver.findElement(cartLink).click();
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


}