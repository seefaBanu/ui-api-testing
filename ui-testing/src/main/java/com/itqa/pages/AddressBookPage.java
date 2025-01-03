package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddressBookPage {
    WebDriver driver;

    private By addNewAddress = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/button");
    private By successedMessage = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private By deleteAddressButton= By.xpath("//*[@id=\"additional-addresses-table\"]/tbody/tr[1]/td[9]/a[2]\n");


    //constructor
    public AddressBookPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickedButton() {
        driver.findElement(addNewAddress).click();  // Click the search button using the correc
    }

    public String getSuccessMessage() {
        return driver.findElement(successedMessage).getText();}

    public void removeAllAddresses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> addressRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='additional-addresses-table']/tbody/tr")));

        System.out.println("Found " + addressRows.size() + " address(es) in the table.");

        if (addressRows.size() > 1) {
            int remainingAddresses = addressRows.size() - 1;

            for (int i = 0; i < remainingAddresses; i++) {
                WebElement row = addressRows.get(i);

                WebElement deleteButton = row.findElement(By.xpath("td[9]/a[2]"));
                System.out.println("Clicking delete button for address " + (i + 1));
                deleteButton.click();

                try {
                    WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[2]")));
                    confirmButton.click();
                    System.out.println("Address " + (i + 1) + " deleted successfully.");
                } catch (Exception e) {
                    System.err.println("Error handling confirmation popup for address " + (i + 1) + ": " + e.getMessage());
                }

                addressRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='additional-addresses-table']/tbody/tr")));
            }
        } else {
            System.out.println("There is only one address left, so no removal will be performed.");
        }
    }

}