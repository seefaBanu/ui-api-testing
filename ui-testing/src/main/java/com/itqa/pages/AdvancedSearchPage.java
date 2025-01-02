package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AdvancedSearchPage {
    WebDriver driver;

    // Define locators for the advanced search fields
    private By productNameField = By.id("name");
    private By skuField = By.id("sku");
    private By priceFromField = By.id("price");
    private By priceToField = By.id("price_to");
    private By shortDescriptionField = By.id("short_description"); 
    private By descriptionField = By.id("description"); 
    private By searchButton = By.xpath("//*[@id=\"form-validate\"]/div/div/button/span"); // Search button locator

    private By advancedSearch = By.xpath("/html/body/div[2]/footer/div/ul/li[3]/a");

    // Constructor
    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill in the advanced search fields
    public void fillFields(Map<String, String> fields) {
        // Ensure that each field is filled if the key exists in the map
        fillFieldIfPresent(fields, "Product Name", productNameField);
        fillFieldIfPresent(fields, "SKU", skuField);
        fillFieldIfPresent(fields, "Description", descriptionField);
        fillFieldIfPresent(fields, "Short Description", shortDescriptionField);
        fillFieldIfPresent(fields, "Price From", priceFromField);
        fillFieldIfPresent(fields, "Price To", priceToField);
    }
    private void fillFieldIfPresent(Map<String, String> fields, String fieldName, By fieldLocator) {
        if (fields.containsKey(fieldName)) {
            WebElement field = driver.findElement(fieldLocator);
            field.clear(); // Clear any pre-filled values in the field

            String value = fields.get(fieldName);

            // Check if the value is "empty" and send a blank space, else send the actual value
            if (value.equalsIgnoreCase("empty")) {
                field.sendKeys(" "); // Send a blank space
            } else {
                field.sendKeys(value);
            }
        }
    }

    public void clickButton() {
        driver.findElement(searchButton).click();  // Click the search button using the correct locator
    }

    public void goToAdvancedSearchPage() {
        driver.findElement(advancedSearch).click();
    }

}
