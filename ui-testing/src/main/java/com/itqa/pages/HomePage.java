package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By searchBar = By.id("search");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By firstProduct = By.cssSelector(".products-grid .product-item:first-of-type");
    private By cartItemCounter = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");
    private By comparePageLink = By.xpath("/html/body/div[2]/header/div[2]/ul/li/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void selectFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartItemCounter).getText();
    }

    public void goToComparePage() {
        driver.findElement(comparePageLink).click();
    }
}
