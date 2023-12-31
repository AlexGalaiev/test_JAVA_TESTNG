package org.pageobjects;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.HarReaderMode;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
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
    public String createdLinkLocator = "#created";
    public String noContentApiLink = "#no-content";
    public String moveApiLink = "#moved";
    public String badRequest = "#bad-request";
    public String forbidden = "#forbidden";
    public String notFound = "#invalid-url";
    @FindBy(css = "#linkResponse")
    public WebElement linkResponse;

    public Map<String, List<String>> getExpectedApiCalls(BrowserMobProxy bmp, String locatorOfClickElement) throws IOException, HarReaderException {
        bmp.newHar();
        driver.findElement(By.cssSelector(locatorOfClickElement)).click();
        Har harreaded = bmp.endHar();
        harreaded.writeTo(new File("src/main/java/org/har/file.har"));
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har=  harReader.readFromFile(new File("src/main/java/org/har/file.har"), HarReaderMode.LAX);
        Map<String,List<String>> apiCallsResult = new HashMap<>();
        for(de.sstoehr.harreader.model.HarEntry entry: har.getLog().getEntries()){
            List<String> cashList = new ArrayList<>();
            cashList.add(String.valueOf(entry.getResponse().getStatus()));
            cashList.add(entry.getResponse().getStatusText().toString());
            apiCallsResult.put(entry.getRequest().getUrl().toString(), cashList);
        }
        return apiCallsResult;
    }

    public boolean checkCodeInReqest(String codeResponse, Map<String, List<String>> totalRequest) {
        for(Map.Entry<String, List<String>> codeRegest : totalRequest.entrySet()) {
            if (codeRegest.getKey().contains("https://demoqa.com/")) {
                codeRegest.getValue().contains(codeResponse); {
                    System.out.println(codeRegest);
                    return true;
                }
            }
        }
        return false;
    };

}


