package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ComparePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".column.main")
    private WebElement comparePageContent;

    @FindBy(xpath = "//button[@title='Compare']")
    private WebElement compareButton;


    public ComparePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public Boolean isComparePageHavingProducts() {
        List<WebElement> productElements = driver.findElements(By.cssSelector(".data.table.table-comparison tbody tr"));
        if (productElements.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }



}