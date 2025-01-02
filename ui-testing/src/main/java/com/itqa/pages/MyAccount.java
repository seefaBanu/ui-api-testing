package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccount {
    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the success message
    private By successMsg = By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");


    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

}
