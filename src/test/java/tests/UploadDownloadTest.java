package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.UploadDownloadFilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadDownloadTest extends BaseTest {
    private File fileToUpload = new File("src/main/java/org/functions/fileToDownload.txt");

    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_UPLOAD_DOWNLOAD);
    }
    @AfterMethod
    public void afterMthod(){
        driver.quit();
    }
    @Test
    public void uploadBtnTest(){
        new UploadDownloadFilePage(driver)
                .uploadFile(fileToUpload);
        Assert.assertEquals(new UploadDownloadFilePage(driver).fakePath.getText(), "C:\\fakepath\\fileToDownload.txt");
    }

}
