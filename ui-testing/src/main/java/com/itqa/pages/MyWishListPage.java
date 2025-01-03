package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyWishListPage {
    WebDriver driver;

    // Assuming there is a success message element after the advanced search is performed
    private By succeedMessage = By.xpath ("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div" ); // Adjust the selector based on the actual element

    public MyWishListPage (WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the success message
    public String getSuccessMessage() {
        return driver.findElement(succeedMessage).getText();
    }
}



