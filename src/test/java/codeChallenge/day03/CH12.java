package codeChallenge.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CH12 extends TestBase {

    /*
     Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
     driver.get("https://guest:guest@jigsaw.w3.org/HTTP/Basic/");
     Verify body contains "Your browser made it!"

     Kaynak : https://www.browserstack.com/docs/automate/selenium/basic-http-authentication
    */

    @Test
    public void test(){

        driver.get("https://guest:guest@jigsaw.w3.org/HTTP/Basic/");

        // Verify body contains "Your browser made it!"

        WebElement body = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(body.getText().contains("Your browser made it!"));

    }


}
