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
    private By SecondProduct = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a");
    private By cartItemCounter = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");
    private By comparePageLink = By.xpath("/html/body/div[2]/header/div[2]/ul/li/a");


    private By signInLink = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");

    private By AdvancedSearch = By.xpath("/html/body/div[2]/footer/div/ul/li[3]/a");
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

    public void selectSecondProduct() {
        driver.findElement(SecondProduct).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartItemCounter).getText();
    }

    public void goToComparePage() {
        driver.findElement(comparePageLink).click();
    }
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void clickOnLink(String linkText) {
        By linkLocator = By.linkText(linkText);
        driver.findElement(AdvancedSearch).click();
    }
    
    public void clickTheToggle() {
        driver.findElement(clickToggle).click();
    }

}
