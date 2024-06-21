package codeChallenge.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class CH13 extends TestBase {

    /*
    https://bonigarcia.dev/selenium-webdriver-java/iframes.html adresine gidin
    Paragraf sayısının 20 adet oldugunu dogrulayın
    */


    @Test
    public void test1() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");


        /*
        ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe") ifadesi,
        "my-iframe" adındaki bir iframe'in yüklendiğini bekler. İframe kullanılabilir hale geldiğinde,
        bu ifade WebDriver'ın bu iframe'e geçiş yapmasını sağlar.
        Bu, iframe içeriğine erişmek ve işlem yapmak için kullanışlıdır.
        */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));

        List<WebElement> list = driver.findElements(By.xpath("//p"));

        Assert.assertEquals(20, list.size());

    }

    @Test
    public void test2() {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");

       /*
        ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0) ifadesi,
        sayfadaki bir veya daha fazla web öğesinin (HTML öğeleri)
        varlığını bekler. pName bir By nesnesi olmalıdır ve
        bu nesnenin temsil ettiği öğelerin sayısının 0'dan fazla olduğunu kontrol eder.
        Yani, pName ile belirtilen türdeki web öğelerinin sayısı 0'dan fazla olduğunda
        bekleme işlemi sona erer ve test devam eder.
        */

        driver.switchTo().frame(driver.findElement(By.id("my-iframe")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//p"), 0));

        List<WebElement> list = driver.findElements(By.xpath("//p"));

        Assert.assertEquals(20, list.size());

    }
}
