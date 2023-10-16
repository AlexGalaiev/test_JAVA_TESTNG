package org.pageobjects;

import org.constants.ApplicationConstants;
import org.constants.ApplicationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

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
    @FindBy(css = ".-pageSizeOptions")
    private WebElement sizeDropDown;
    @FindBy(css = ".-totalPages")
    private WebElement totalPages;
    @FindBy(css = ".-next")
    private WebElement nextBtn;

    private By RegistrationForm = By.cssSelector(ApplicationLocators.REG_FORM);
    //------------------------------------------------------------------------------------

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
        new AddRandomUserFormPage(driver).generateRandomPersonShort();
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
            fillRegistrationForm();
        }
        return this;
    }

    public WebTablePage closeExistFields() {
        clickGroupOfElements(deleteFiledBtns);
        return this;
    }
    public WebTablePage editEmailFieldInWebTable() {
        singleEditBtn.click();
        clearElementField(ApplicationLocators.REG_FORM_EMAIL);
        sendKeysElement(ApplicationLocators.REG_FORM_EMAIL, ApplicationConstants.TEST_EMAIL);
        clickElementByCSS("#submit");
        return this;
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
        return this;
    };
    public WebTablePage changeSizeOfDropDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.keyDown(sizeDropDown, Keys.ARROW_DOWN).keyDown(sizeDropDown, Keys.ARROW_DOWN).perform();
        sizeDropDown.click();
        searchByXpathInsideElement(sizeDropDown, "//option[contains(text(), 5)][1]").click();
        return this;
    }
    public boolean checkNumberOfPages(String expectedNumberOfPages){
        String numberOfTotalPagesDisplayed = totalPages.getText();
        return numberOfTotalPagesDisplayed.equals(expectedNumberOfPages);
    }
    public boolean checkBtnNextIsActive(){
        Boolean nextBtnActive = false;
        if (nextBtn.getAttribute("disabled").equals("null")){
            nextBtnActive = true;
        }return nextBtnActive;
    }
}

