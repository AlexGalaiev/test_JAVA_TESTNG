package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadDownloadFilePage extends BasePage {
    public UploadDownloadFilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#downloadButton")
    private WebElement downloadBtn;

    @FindBy(css = "#uploadFile")
    public WebElement uploadBtn;

    @FindBy(css = "#uploadedFilePath")
    public WebElement fakePath;

    public UploadDownloadFilePage uploadFile(File fileToUpload){
        uploadBtn.sendKeys(fileToUpload.getAbsolutePath());
        return this;
    }
}
