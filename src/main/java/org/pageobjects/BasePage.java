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
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected List<String> getStringFromWebElement(List<WebElement> elementsList) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : elementsList) {
            listOfStrings.add(element.getText().toLowerCase());
        }
        return listOfStrings;
    }

    protected void waitElement(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void waitAlert(){
        WebDriverWait webdriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webdriverWait.until(ExpectedConditions.alertIsPresent());
    }
    protected void sendKeysElement(String locator, String text){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);}
    protected void clickElementByCSS(String locator) {driver.findElement(By.cssSelector(locator)).click();}
    protected void clearElementField(String locator) {driver.findElement(By.cssSelector(locator)).clear();}
    protected WebElement searchByXpathInsideElement(WebElement elementToSearch, String locator) {
        return elementToSearch.findElement(By.xpath(locator));
    }


}
