package com.itqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    WebDriver driver;
    private WebDriverWait wait;

    private By compareButtonFirstProduct = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div/div[2]/a[2]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Correctly use Duration
    }
    public void selectProduct(int index) {
        List<WebElement> products = driver.findElements(By.cssSelector("ol.products.list.items.product-items > li.item.product.product-item"));

        if (index < 0 || index >= products.size()) {
            throw new IllegalArgumentException("Invalid product index: " + index);
        }
        WebElement product = products.get(index);
        WebElement compareButton = product.findElement(By.cssSelector(".action.tocompare"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        wait.until(ExpectedConditions.elementToBeClickable(compareButton));
        compareButton.click();
    }

    public Integer getCompareCount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement compareCountElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[@class='counter qty' and @data-bind='text: compareProducts().countCaption']")
                    )
            );            String countText = compareCountElement.getText();
            String count = countText.split(" ")[0];
            System.out.println("count is"+ count);
            return Integer.parseInt(count);
        } catch (Exception e) {
            System.err.println("Error retrieving compare count: " + e.getMessage());
            return null;
        }
    }

}
