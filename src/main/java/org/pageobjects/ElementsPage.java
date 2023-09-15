package org.pageobjects;

import org.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{

    public ElementsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#userForm #userName")
    private WebElement textBox_userName;
    @FindBy(css = "#userForm #userEmail")
    private WebElement textBox_userEmail;
    @FindBy(css = "#userForm #currentAddress")
    private WebElement textBox_cuurentAddress;
    @FindBy(css = "#userForm #permanentAddress")
    private WebElement textBox_permanentAddress;
    @FindBy(css = "#submit")
    private WebElement textBOX_submitBTN;
    @FindBy(css = "#output #name")
    public WebElement textBox_finalName;
    @FindBy(css = "#output #email")
    public WebElement textBox_finalEmail;
    @FindBy(css = "#output #currentAddress")
    public WebElement textBox_finalcurrentAddress;
    @FindBy(css = "#output #permanentAddress")
    public WebElement textBox_finalpermanentAddress;

    public ElementsPage fillTextBoxForm(){
        textBox_userName.sendKeys(ApplicationConstants.TEST_DATA);
        textBox_userEmail.sendKeys(ApplicationConstants.TEST_EMAIL);
        textBox_cuurentAddress.sendKeys(ApplicationConstants.TEST_CURRENT_ADRESS);
        textBox_permanentAddress.sendKeys(ApplicationConstants.TEST_PERMANENT_ADRESS);
        textBOX_submitBTN.click();
        return new ElementsPage(driver);
    }
    public String getTextinResultpopup(String additionalText, WebElement elementWithText){
        return additionalText + elementWithText.getText();
    }
}
