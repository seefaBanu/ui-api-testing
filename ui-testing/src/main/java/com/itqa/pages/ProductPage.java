package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By addToCartButton = By.xpath("//*[@id=\"product-addtocart-button\"]");
    private By successMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

    // Method to select size
    public void selectSize(String size) {
        String sizeXpath = String.format("//*[@id='option-label-size-143-item-%s']", getSizeId(size));
        driver.findElement(By.xpath(sizeXpath)).click();
    }

    // Method to select color
    public void selectColor(String color) {
        String colorXpath = String.format("//*[@id='option-label-color-93-item-%s']", getColorId(color));
        driver.findElement(By.xpath(colorXpath)).click();
    }

    // Method to click Add to Cart
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    //Method to get the success message
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // Helper method to get size ID
    private String getSizeId(String size) {
        switch (size.toUpperCase()) {
            case "XS": return "166";
            case "S": return "167";
            case "M": return "168";
            case "L": return "169";
            case "XL": return "170";
            default: return "";
        }
    }

    // Helper method to get color ID
    private String getColorId(String color) {
        switch (color.toLowerCase()) {
            case "blue": return "50";
            case "orange": return "56";
            case "purple": return "57";
            default: return "";
        }
    }
}