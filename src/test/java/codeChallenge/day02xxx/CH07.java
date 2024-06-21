package codeChallenge.day02xxx;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class CH07 extends TestBase {

    /*
    1) Open the browser
    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
    3) 1 + 3
    4) ... should be 4, wait for it
    */

    @Test
    public void test() {

        //  2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");


        //    3) 1 + 3

        islem("9");
        islem("-");
        islem("5");
        islem("=");

        //    4) ... should be 4, wait for it

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class=\"screen\"]"), "4"));

        String actual = driver.findElement(By.xpath("//div[@class=\"screen\"]")).getText();
        Assert.assertEquals("4", actual);


    }

    public void islem(String input) {

        driver.findElement(By.xpath("//span[.='" + input + "']")).click(); // //span[.='5']
    }
}
