package org.pageobjects;

import org.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public static WebDriver driver;
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "banner-image")
    private WebElement elementCard;

    public MainPage elementsCardClick(){
        elementCard.click();
        return new MainPage(driver);
    }
}
