package topics;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C48_TakeScreenShot1 extends TestBase {
/*
    Go to Clarusway
    Take full page screenshot
    Take a specific element's screenshot
*/
//
    @Test
    public void fullPageScreenShotTest() throws IOException {
//        Go to Clarusway
        driver.get("https://clarusway.com");

//        Take full page screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File ss = screenshot.getScreenshotAs(OutputType.FILE);

        String time = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();
        String url = driver.getCurrentUrl();

        FileUtils.copyFile(ss, new File("test-output/screenshots/"+time+".png") );

    }



    @Test//Take Google's logo's screenshot
    public void specificElementScreenShotTest() throws IOException {

        driver.get("https://google.com");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));

        File logoSs = logo.getScreenshotAs(OutputType.FILE);

        String time = new SimpleDateFormat("yyMMddhhmmss").format(new Date())+System.nanoTime();

        FileUtils.copyFile(logoSs, new File("test-output/screenshots/"+time+".png"));//solda test-output yeri oluşturup kayıt yeri oluşturdu.


    }




}