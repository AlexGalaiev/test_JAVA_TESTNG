package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement findByLocator(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator));
    }
    public List<String> getStringFromWebElement(List<WebElement> elementsList) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : elementsList) {
            listOfStrings.add(element.getText().toLowerCase());
        }
        System.out.print(listOfStrings);
        return listOfStrings;
    }

}
