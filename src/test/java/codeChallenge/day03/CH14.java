package codeChallenge.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class CH14 extends TestBase {

    /*
    1. http://zero.webappsecurity.com sayfasina gidin
    2. Signin buttonuna tiklayin
    3. Login alanine  "username" yazdirin
    4. Password alanine "password" yazdirin
    5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
    6. Online Banking menusunden Pay Bills sayfasina gidin
    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    8. tarih kismina "2020-09-10" yazdirin
    9. Pay buttonuna tiklayin
    10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
    */

    @Test
    public void test() {

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //    2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //    3. Login alanine  "username" yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //    4. Password alanine "password" yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //    5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        driver.navigate().back();

        //    6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //    7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("500");

        //    8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //    9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //    10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin

        String actual = driver.findElement(By.xpath("//div[@id='alert_content']/span")).getText();
        String expected = "The payment was successfully submitted.";

        Assert.assertEquals(expected, actual);


    }


}
