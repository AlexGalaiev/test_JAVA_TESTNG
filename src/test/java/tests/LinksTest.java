package tests;

import de.sstoehr.harreader.HarReaderException;
import org.base.BaseTestApi;
import org.constants.ApplicationConstants;
import org.functions.ApiMethos;
import org.pageobjects.LinksPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LinksTest extends BaseTestApi{
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_LINKS);
    }

    @AfterMethod
    public void afterMethod() {
        new File("src/main/java/org/har/file.har").delete();
        driver.quit();
    }
    @Test
    public void codeApiTestCreatedLink() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.createdLinkLocator).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.createdLinkLocator)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.createdLinkLocator));
    }
    @Test
    public void codeApiTestNoContentLink() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.noContentApiLink).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.noContentApiLink)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.noContentApiLink));
    }
    @Test
    public void codeApiTestMoveApiLink() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.moveApiLink).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.moveApiLink)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.moveApiLink));
    }
    @Test
    public void codeApiTestMoveBadRequest() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.badRequest).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.badRequest)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.badRequest));
    }
    @Test
    public void codeApiTestMoveForbiden() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.forbidden).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.forbidden)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.forbidden));
    }
    @Test
    public void codeApiTestNotFound() throws IOException, HarReaderException {
        LinksPage linkPage = new LinksPage(driver);
        Assert.assertTrue(linkPage.checkCodeInReqest(
                new ApiMethos().getExpectedListOfResponse(linkPage.notFound).get(0),
                linkPage.getExpectedApiCalls(bmp, linkPage.notFound)));
        Assert.assertEquals(linkPage.linkResponse.getText(),
                new ApiMethos().getSuccessMSGAfterRedirect(linkPage.notFound));
    }

}
