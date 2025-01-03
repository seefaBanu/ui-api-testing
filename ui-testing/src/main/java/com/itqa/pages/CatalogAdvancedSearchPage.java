package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogAdvancedSearchPage {
    WebDriver driver;

    // Assuming there is a success message element after the advanced search is performed
    private By successMessage = By.xpath ("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]" ); // Adjust the selector based on the actual element

    public CatalogAdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the success message
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
