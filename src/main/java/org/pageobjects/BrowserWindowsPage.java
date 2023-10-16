package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#tabButton")
    private WebElement newTab;
    @FindBy(css = "#windowButton")
    private WebElement newWindow;
    @FindBy(css = "#messageWindowButton")
    private WebElement newWindowWithMSG;
    @FindBy(css = "#sampleHeading")
    private WebElement externalWindowText;

    public BrowserWindowsPage switchToNewTab(){
        newTab.click();
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        return this;
    }
    public String getCurentUrl(){
        return driver.getCurrentUrl().toString();
    }

    public BrowserWindowsPage openNewWindow(){
        newWindow.click();
        return this;
    }
    public String getExternalWindowText(){
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        return externalWindowText.getText().toString();
    }
    public BrowserWindowsPage openNewWindowWithMSG(){
        newWindowWithMSG.click();
        return this;
    }
    public String getExternalBodyText(){
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        return driver.findElement(By.xpath("//body")).getText().toString();
    }

}
