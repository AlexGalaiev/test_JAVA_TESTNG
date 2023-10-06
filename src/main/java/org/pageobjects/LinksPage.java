package org.pageobjects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.constants.ApplicationConstants;
import org.functions.ApiMethos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#simpleLink")
    private WebElement simpleLink;
    @FindBy(css = "#dynamicLink")
    private WebElement dynamiklink;
    public List<String> locators = Arrays.asList(
            "createdLinkLocator",
            "noContentApiLink",
            "moveApiLink",
            "badRequest",
            "forbidden",
            "notFound"
            );

    public String createdLinkLocator = "#created";
    public String noContentApiLink = "#no-content";
    public String moveApiLink = "#moved";
    public String badRequest = "#bad-request";
    public String forbidden = "#forbidden";
    public String notFound = "#invalid-url";
    @FindBy(css = "#linkResponse")
    public WebElement linkResponse;

    public List<String> getExpectedApiCalls(BrowserMobProxy bmp, String locatorOfClickElement) {
        bmp.newHar();
        driver.findElement(By.cssSelector(locatorOfClickElement)).click();
        Har har = bmp.endHar();
        List<String> apiCallsResult = new ArrayList<>();
        List<HarEntry> entries = har.getLog().getEntries();
        for(HarEntry entry: entries){
            apiCallsResult.add(entry.getRequest().getUrl().toString());
            apiCallsResult.add(String.valueOf(entry.getResponse().getStatus()));
            apiCallsResult.add(entry.getResponse().getStatusText().toString());
        }
        return apiCallsResult;
    }
    public boolean checkCodeInReqest(String codeResponse, List<String> totalRequest) {
        return totalRequest.contains(codeResponse);
    }
}

