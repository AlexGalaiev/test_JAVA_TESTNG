package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CheckBoxsPage extends BasePage {

    public CheckBoxsPage(WebDriver driver) {
        super(driver);
    }
    @FindAll({@FindBy(css = ".text-success")})
    public List<WebElement> selectedPoints;
    @FindBy(css = ".rct-option-expand-all")
    private WebElement plusBtn;

    @FindBys({@FindBy(css = ".rct-title")})
    private List<WebElement> pointNameInFoldersTree;
    @FindBy(css = "[for='tree-node-home']")
    private WebElement mainHomeCheckbox;
    @FindBy(css = ".rct-icon-expand-close")
    private List<WebElement> dropdownArrowClosed;
    @FindBy(xpath = "//*[contains(text(),'Desktop')]")
    private WebElement nameDesktopPoint;
    @FindBy(css = ".rct-node-leaf")
    private List<WebElement> selectedCategoriesSecondGroup;

    public CheckBoxsPage openMenuAndFillAllCheckboxes() {
        plusBtn.click();
        mainHomeCheckbox.click();
        return new CheckBoxsPage(driver);
    }
    public List<String> getSelectedPointsList(){
        return getStringFromWebElement(selectedPoints);
    }
    public List<String> getChoosenPointNameInPointsTree(){
        return getStringFromWebElement(pointNameInFoldersTree);
    }
    public List<String> getSelectedCategoriesSecondGroup(){
        return getStringFromWebElement(selectedCategoriesSecondGroup);
    }
    public CheckBoxsPage clickDropDownArrow(){
        dropdownArrowClosed.get(0).click();
        return new CheckBoxsPage(driver);
    }
    public CheckBoxsPage clickDescktopPoint(){
        nameDesktopPoint.click();
        return new CheckBoxsPage(driver);
    }
}