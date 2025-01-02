package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    //locator
    private By searchBar = By.id("search");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By firstProduct = By.cssSelector(".products-grid .product-item:first-of-type");
    private By cartItemCounter = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");
    private By AdvancedSearch = By.xpath("/html/body/div[2]/footer/div/ul/li[3]/a");


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

    public void clickOnLink(String linkText) {
        By linkLocator = By.linkText(linkText);  
        driver.findElement(AdvancedSearch).click();  
    }

}
