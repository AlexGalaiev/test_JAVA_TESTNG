package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreationFormPage extends BasePage{
    @FindBy(css = "#firstName")
    private WebElement confirmFormFirstName;
    @FindBy(css = "#lastName")
    private WebElement confirmFormLastName;
    @FindBy(css = "#userEmail")
    private WebElement confirmFormUserEmail;
    @FindBy(css = "#userNumber")
    private WebElement confirmFormUserNumber;
    @FindBy(css = "#subjectsContainer")
    private WebElement confirmFormUserSubject;

    public CreationFormPage(WebDriver driver) {
        super(driver);
    }
    public CreationFormPage fillRegistartionForm(){
        AddRandomUserFormPage user = new AddRandomUserFormPage(driver);
//        firstName.sendKeys(getFakeName());
//        lastName.sendKeys(getFakeLastName());
//        userEmail.sendKeys(getFakeUsermail());
//        confirmFormUserNumber.sendKeys(user.getFakePhoneNumber());
//        user.selectGender();
//        user.selectHobbyCheckboxes();
//        user.selectDateOfBirth("10", "October", "1990");
        return this;
    }

}

