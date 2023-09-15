package org.pageobjects;

import net.datafaker.Faker;
import org.constants.ApplicationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }
    Faker faker = new Faker();
    private String getRandomName(){return faker.name().firstName();}
    private String getRandomLastName(){return faker.name().lastName();}
    private String getRandomEmail(){return faker.address().mailBox();}
    private String getRandomNumber(){return faker.number().toString();}
    private String getFunnyName() {return faker.funnyName().name();}
    @FindAll({@FindBy(xpath = "//*[contains(@id, 'delete-record')]")})
    private List<WebElement> deleteFiledBtns;
    private By RegistrationForm = By.cssSelector(ApplicationLocators.REG_FORM);
    public WebTablePage fillRegForm(){
        sendKeysElement(ApplicationLocators.REG_FORM_FIRST_NAME, getRandomName());
        sendKeysElement(ApplicationLocators.REG_FORM_LAST_NAME, getRandomLastName());
        sendKeysElement(ApplicationLocators.REG_FORM_EMAIL, getRandomEmail());
        sendKeysElement(ApplicationLocators.REG_FORM_AGE, getRandomNumber());
        sendKeysElement(ApplicationLocators.REG_FORM_SALARY, getRandomNumber());
        sendKeysElement(ApplicationLocators.REG_FORM_DEPARTMENT, getFunnyName());
        clickElementByCSS(ApplicationLocators.REG_FORM_SUBMIT);
        return new WebTablePage(driver);
    }
    public WebTablePage closeExistFields() {
        if (deleteFiledBtns.get(1).isDisplayed()) {
            clickGroupOfElements(deleteFiledBtns);
        };
        return new WebTablePage(driver);
    };
    public WebTablePage addPointTofield(){
        clickElementByCSS(ApplicationLocators.ADD_BTN);
        waitElement(RegistrationForm);
        return new WebTablePage(driver);
    }
}
