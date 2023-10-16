package org.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#alertButton")
    private WebElement alertBtn;
    @FindBy(css = "#timerAlertButton")
    private WebElement alertBtnWithDelay;
    @FindBy(css = "#confirmButton")
    private WebElement alertBtnWithConfirmation;
    @FindBy(css = "#confirmResult")
    public WebElement confirmationResultMSG;
    @FindBy(css = "#promtButton")
    private WebElement alertBtnWithTextMsg;
    @FindBy(css = "#promptResult")
    public WebElement confirmationMSG;

    public AlertPage clickAlertBtn(){
        alertBtn.click();
        return this;
    }
    public AlertPage clickAlertBtnWithDelay(){
        alertBtnWithDelay.click();
        waitAlert();
        return this;
    }
    public String getMsgFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText().toString();
    }
    public AlertPage clickAlertWith2Btns(){
        alertBtnWithConfirmation.click();
        waitAlert();
        return this;
    }
    public AlertPage acceptAlert(){
        driver.switchTo().alert().accept();
        return this;
    }
    public AlertPage dismissAlert(){
        driver.switchTo().alert().dismiss();
        return this;
    }
    public AlertPage clickAlertBtnWithTextMsg(){
        alertBtnWithTextMsg.click();
        waitAlert();
        return this;
    }

    public String generateRandomMSG(){
        return new AddRandomUserFormPage(driver).faker.name().firstName().toString();
    }
    public AlertPage sendTextToAllert(String textFoAllert){
        driver.switchTo().alert().sendKeys(textFoAllert);
        driver.switchTo().alert().accept();
        return this;
    }

}
