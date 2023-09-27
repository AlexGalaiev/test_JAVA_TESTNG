package org.pageobjects;

import net.datafaker.Faker;
import org.constants.ApplicationConstants;
import org.constants.ApplicationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }
    Faker faker = new Faker();
    Random random = new Random();
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
    @FindBy(css = ".rt-td")
    private WebElement singleWebTable;

    private By RegistrationForm = By.cssSelector(ApplicationLocators.REG_FORM);
    //------------------------------------------------------------------------------------
    private Map<String, String> generateRandomPerson(){
        Map<String, String> randomPerson = new HashMap<String, String>();

        randomPerson.put("firstName", faker.name().firstName());
        randomPerson.put("lastName", faker.name().lastName());
        randomPerson.put("userEmail", faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com");
        randomPerson.put("age", String.valueOf(random.nextInt(90)));
        randomPerson.put("salary", String.valueOf(random.nextInt(10000)));
        randomPerson.put("department", String.valueOf(faker.funnyName().name()));

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
    private void fillRegistrationForm() {
        waitElement(RegistrationForm);
        for(Map.Entry<String, String> mapElement : generateRandomPerson().entrySet()) {
            String key = mapElement.getKey();
            String value = mapElement.getValue();
            sendKeysElement("#"+key, value);
        }
        clickElementByCSS(ApplicationLocators.REG_FORM_SUBMIT);
    }
    public boolean сheckElementInWebTable(String elementToSearch){
        List<WebElement> tableListOfdata = webTableFields.findElements(By.cssSelector(".rt-td"));
        List<String> tableOfStrings = new ArrayList<>();
        for(WebElement element: tableListOfdata){
            tableOfStrings.add(element.getText());
        }
        Boolean foundELementOnWebTables = false;
        for (String element : tableOfStrings){
            if (element.equals(elementToSearch)) {
                foundELementOnWebTables = true;
                break;
            }
        }
        return foundELementOnWebTables;
    }


    //--------------------------------------------------------------------------------------
    public WebTablePage createUserInBase(Integer numberOfUsers) {
        for(int i=1; i<=numberOfUsers; i++) {
            clickElementByCSS(ApplicationLocators.ADD_BTN);
            waitElement(RegistrationForm);
            fillRegistrationForm();
        }
        return new WebTablePage(driver);
    }

    public WebTablePage closeExistFields() {
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
    public String getUserCredentialsFromWebList(Integer index){
        List<WebElement> tableListOfdata = webTableFields.findElements(By.cssSelector(".rt-td"));
        List<String> tableOfStrings = new ArrayList<>();
        for(WebElement element: tableListOfdata){
            tableOfStrings.add(element.getText());
        }
        return tableOfStrings.get(index);
    }

    public WebTablePage useSearchField(String searchText) {
        searchBoxFiels.clear();
        searchBoxFiels.sendKeys(searchText);
        return new WebTablePage(driver);
    };

}

