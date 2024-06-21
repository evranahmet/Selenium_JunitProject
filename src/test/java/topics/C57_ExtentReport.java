package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C57_ExtentReport extends TestBase {

    @Test
    public void test1(){
        //Go to Clarusway
        extentTest = extentReportsSetUp().createTest("Clarusway Anasayfa", "Anasayfa gezinme testi");

        extentTest.info("Anasayfaya gidiliyor");

        driver.get("https://clarusway.com");

        extentTest.pass("Anasayfaya gidildi.");

        driver.findElement(By.xpath("//div[@data-id='4862572d']")).click();

        extentTest.pass("SDET tıklandı");

        driver.navigate().back();

        extentTest.pass("Anasayfaya dönüldü.");

        extentReports.flush();


    }

}
