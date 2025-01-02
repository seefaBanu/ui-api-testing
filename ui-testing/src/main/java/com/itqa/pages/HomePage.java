package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private WebDriverWait wait;
    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    //locator
    private By searchBar = By.id("search");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By firstProduct = By.cssSelector(".products-grid .product-item:first-of-type");
    private By cartItemCounter = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");

    private By signInLink = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");

    private static By clickToggle = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void clickTheToggle() {
        driver.findElement(clickToggle).click();
    }

}
