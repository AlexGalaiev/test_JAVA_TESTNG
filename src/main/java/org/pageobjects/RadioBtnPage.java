package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioBtnPage extends BasePage{

    public RadioBtnPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[for='yesRadio']")
    private WebElement yesRadioBtn;
    @FindBy(css = "[for='impressiveRadio']")
    private WebElement impressiveBtn;
    @FindBy(css = "#noRadio")
    private WebElement noRadioBtn;
    @FindBy(css = ".text-success")
    public WebElement successMSG;
    By textMsg = By.cssSelector(".mt-3");
    public RadioBtnPage clickRadioBtnYes() {
        yesRadioBtn.click();
        return new RadioBtnPage(driver);
    }
    public RadioBtnPage clickRadioBtnImpresive() {
        impressiveBtn.click();
        return new RadioBtnPage(driver);
    }
    public RadioBtnPage waitElementAnswer(){
        waitElement(textMsg);
        return new RadioBtnPage(driver);
    }

}
