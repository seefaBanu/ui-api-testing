package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage {
    WebDriver driver;

    private By addNewAddress = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/button");
    private By successedMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    //constructor
    public AddressBookPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickedButton() {
        driver.findElement(addNewAddress).click();  // Click the search button using the correc
    }

    public String getSuccessMessage() {
        return driver.findElement(successedMessage).getText();}


}
