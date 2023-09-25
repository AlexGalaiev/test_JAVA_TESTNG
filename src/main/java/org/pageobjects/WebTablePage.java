package org.pageobjects;

import net.datafaker.Faker;
import org.constants.ApplicationConstants;
import org.constants.ApplicationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }
    Faker faker = new Faker();
    Random random = new Random();
    private String getRandomName(){return faker.name().firstName();}
    private String getRandomLastName(){return faker.name().lastName();}
    private String getRandomEmail(){return faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com";}
    private Integer getRandomAge(){return random.nextInt(90);}
    private Integer getRandomSalaryValue(){return random.nextInt(10000);}
    private String getFunnyName() {return faker.funnyName().name();}
    private By noDataText = By.cssSelector(".rt-noData");
    @FindAll({@FindBy(xpath = "//*[contains(@id, 'delete-record')]")})
    public List<WebElement> deleteFiledBtns;
    @FindBy(css = "#delete-record-")
    private WebElement singleDeleteBtn;
    @FindAll({@FindBy(xpath = "//*[contains(@id, 'edit-record')]")})
    private List<WebElement> editFilesBtnsList;
    @FindBy(css = "#edit-record-1")
    private WebElement singleEditBtn;
    @FindBy(css = "#searchBox")
    private WebElement searchBoxFiels;
    @FindBy(xpath = "//div[@class='action-buttons']/../..")
    private WebElement webTableFields;

    private By RegistrationForm = By.cssSelector(ApplicationLocators.REG_FORM);

    private List<String> generateRandomPerson(){
        List<String> randomPerson = new ArrayList<String>();
        randomPerson.add(getRandomName());
        randomPerson.add(getRandomLastName());
        randomPerson.add(getRandomEmail());
        randomPerson.add(getRandomAge().toString());
        randomPerson.add(getRandomSalaryValue().toString());
        randomPerson.add(getFunnyName());
        return randomPerson;
    }
    private void clickGroupOfElements(List<WebElement> elementsList) {
        List<String> deleteBtnsList = new ArrayList<String>();
        for(int i=1; i<=elementsList.size(); i++) {
            deleteBtnsList.add("#delete-record-" + i);
        }
        for (String locator: deleteBtnsList){
            driver.findElement(By.cssSelector(locator)).click();
        }
    }
    public WebTablePage fillRegForm(){
        sendKeysElement(ApplicationLocators.REG_FORM_FIRST_NAME, generateRandomPerson().get(0));
        sendKeysElement(ApplicationLocators.REG_FORM_LAST_NAME, generateRandomPerson().get(1));
        sendKeysElement(ApplicationLocators.REG_FORM_EMAIL, generateRandomPerson().get(2));
        sendKeysElement(ApplicationLocators.REG_FORM_AGE, generateRandomPerson().get(3));
        sendKeysElement(ApplicationLocators.REG_FORM_SALARY, generateRandomPerson().get(4));
        sendKeysElement(ApplicationLocators.REG_FORM_DEPARTMENT, generateRandomPerson().get(5));
        clickElementByCSS(ApplicationLocators.REG_FORM_SUBMIT);
        return new WebTablePage(driver);
    }
    public WebTablePage closeExistFields() {
        System.out.println(deleteFiledBtns.size());
        clickGroupOfElements(deleteFiledBtns);
        waitElement(noDataText);
        return new WebTablePage(driver);
    }
    public WebTablePage editEmailFieldInWebTable() {
        singleEditBtn.click();
        clearElementField(ApplicationLocators.REG_FORM_EMAIL);
        sendKeysElement(ApplicationLocators.REG_FORM_EMAIL, ApplicationConstants.TEST_EMAIL);
        clickElementByCSS(ApplicationLocators.REG_FORM_SUBMIT);
        return new WebTablePage(driver);
    }
    public String getRandomPersonCredentials(Integer index){
        return generateRandomPerson().get(index).toString();
    }
    public WebTablePage addPointTofield(){
        clickElementByCSS(ApplicationLocators.ADD_BTN);
        waitElement(RegistrationForm);
        return new WebTablePage(driver);
    }
    public String searchEmailInWebTable(){
        List<WebElement> tableListOfdata = webTableFields.findElements(By.cssSelector(".rt-td"));
        List<String> tableOfStrings = new ArrayList<>();
        for(WebElement element: tableListOfdata){
            tableOfStrings.add(element.getText());
        }
        return tableOfStrings.get(3);
    }
}
