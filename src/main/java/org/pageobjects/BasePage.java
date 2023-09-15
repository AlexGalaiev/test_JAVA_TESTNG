package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List<String> getStringFromWebElement(List<WebElement> elementsList) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : elementsList) {
            listOfStrings.add(element.getText().toLowerCase());
        }
        return listOfStrings;
    }
    public void clickGroupOfElements(List<WebElement> elementsList) {
        for (WebElement element : elementsList) {
            element.click();
        }
    }
    public void waitElement(By elementLocatorToWait) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocatorToWait));
    }
    public void sendKeysElement(String locator, String text){driver.findElement(By.cssSelector(locator)).sendKeys(text);}
    public void clickElementByCSS(String locator){driver.findElement(By.cssSelector(locator)).click();}
    public void clickElementByXPATH(String locator) {driver.findElement(By.xpath(locator)).click();}
}
