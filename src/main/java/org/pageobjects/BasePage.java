package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement findByLocator(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator));
    }
    public void comparisonValues(List<WebElement> valuesForComparison, WebElement list)

}
