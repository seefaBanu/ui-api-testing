package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAccountPage {
    WebDriver driver;

    private By addressBookLink = By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[6]/a");
    private By myAccount =By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");

    //constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

        public void clickAddressBookLink() {
            driver.findElement(addressBookLink).click();
        }

        public void goToMyAccountPage() {
            driver.findElement(myAccount ).click();
        }

    }


