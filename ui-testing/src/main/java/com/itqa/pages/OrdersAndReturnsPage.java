package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrdersAndReturnsPage {
    WebDriver driver;
    private WebDriverWait wait;
    public OrdersAndReturnsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Correctly use Duration
    }

    public void enterField(String fieldLabel, String text) {
        String xpath = "//label[span[text()='" + fieldLabel + "']]/following-sibling::div//input";
        WebElement inputField = driver.findElement(By.xpath(xpath));
        inputField.sendKeys(text);
    }

    public String getOrderIdOnPage() {
        String xpath = "//*[@id='maincontent']/div[1]/h1/span";
        String orderText = driver.findElement(By.xpath(xpath)).getText();
        String orderId = orderText.replace("Order # ", "").trim();
        return orderId;
    }
}
