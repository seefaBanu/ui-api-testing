package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class AddNewAddressPage {
    WebDriver driver;

    // Locators
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By companyField = By.id("company");
    private By phoneNumberField = By.id("telephone");
    private By streetAddressField = By.id("street_1");
    private By cityField = By.id("city");
    private By stateField = By.id("region_id");
    private By postCodeField = By.xpath("//*[@id=\"zip\"]");
    private By countryField = By.id("country");

    private By saveButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");

    // Constructor
    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    // Scroll to an element
    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to fill in the fields
    public void fillFields(Map<String, String> fields) {
        // Check if all required fields are present in the map
        validateFields(fields);

        // Populate fields with scrolling
        scrollToElement(firstNameField);
        driver.findElement(firstNameField).sendKeys(fields.get("First Name"));

        scrollToElement(lastNameField);
        driver.findElement(lastNameField).sendKeys(fields.get("Last Name"));

        scrollToElement(companyField);
        driver.findElement(companyField).sendKeys(fields.get("Company"));

        scrollToElement(phoneNumberField);
        driver.findElement(phoneNumberField).sendKeys(fields.get("Phone Number"));

        scrollToElement(streetAddressField);
        driver.findElement(streetAddressField).sendKeys(fields.get("Street Address"));

        scrollToElement(cityField);
        driver.findElement(cityField).sendKeys(fields.get("City"));

        scrollToElement(stateField);
        driver.findElement(stateField).sendKeys(fields.get("State"));

        scrollToElement(postCodeField);
        driver.findElement(postCodeField).sendKeys(fields.get("Post Code"));

        scrollToElement(countryField);
        driver.findElement(countryField).sendKeys(fields.get("Country"));
    }

    // Validate if all required keys are present
    private void validateFields(Map<String, String> fields) {
        String[] requiredFields = {
                "First Name", "Last Name", "Company", "Phone Number",
                "Street Address", "City", "State", "Post Code", "Country"
        };

        for (String field : requiredFields) {
            if (!fields.containsKey(field)) {
                throw new IllegalArgumentException("Missing required field: " + field);
            }
            if (fields.get(field) == null || fields.get(field).isEmpty()) {
                throw new IllegalArgumentException("Field '" + field + "' cannot be null or empty.");
            }
        }
    }

    // Click Save Button
    public void clickSaveButton() {
        scrollToElement(saveButton); // Scroll before clicking the button
        driver.findElement(saveButton).click();
    }
}
