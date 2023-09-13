package org.pageobjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxsPage extends BasePage {

    public CheckBoxsPage(WebDriver driver) {
        super(driver);
    }
    @FindAll({@FindBy(css = ".text-success")})
    private List<WebElement> successText;
    @FindBy(css = ".rct-option-expand-all")
    private WebElement plusBtn;
    @FindAll({@FindBy(css = ".rct-title")})
    private List<WebElement> pointName;
    @FindBy(css = "#tree-node-home")
    private WebElement homeCheckbox;
}