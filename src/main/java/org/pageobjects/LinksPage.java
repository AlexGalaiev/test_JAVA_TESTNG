package org.pageobjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.functions.ApiCalls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LinksPage extends BasePage{

    public LinksPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#simpleLink")
    private WebElement simpleLink;
    @FindBy(css = "#dynamicLink")
    private WebElement dynamiklink;
    @FindBy(css = "#created")
    private WebElement createdApiLink;
    @FindBy(css = "#no-content")
    private WebElement noContentApiLink;
    @FindBy(css = "#moved")
    private WebElement moveApiLink;
    @FindBy(css = "#bad-request")
    private WebElement badRequest;
    @FindBy(css = "#forbidden")
    private WebElement forbidden;
    @FindBy(css = "#invalid-url")
    private WebElement notFound;

    public LinksPage getTrafficInfo() throws IOException {
        ApiCalls apiCalls = new ApiCalls();
        return this;
    }
}
