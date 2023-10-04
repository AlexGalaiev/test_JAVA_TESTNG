package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.base.BaseTest;
import org.base.BaseTestApi;
import org.constants.ApplicationConstants;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LinksTest extends BaseTestApi{
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_LINKS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void codeApiTest() throws IOException, InterruptedException {
        bmp.newHar();
        driver.findElement(By.cssSelector("#created")).click();
        Har har = bmp.endHar();
        List<HarEntry> entries = har.getLog().getEntries();
        for(HarEntry entry: entries){
            System.out.println(entry.getRequest().getUrl());
            System.out.println(entry.getResponse().getStatus());
            System.out.println(entry.getResponse().getStatusText());
        }


    }

}
