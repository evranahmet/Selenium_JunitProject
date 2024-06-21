package codeChallenge.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class CH10 extends TestBase {

    /*
    1) Open the browser
    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
    3)Choose "Three"
    4)Verify option Label
   */


    @Test
    public void test() {

        //2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // 3)Choose "Three"

        WebElement selectElement = driver.findElement(By.xpath("//select[@class=\"form-select\"]"));

        Select select = new Select(selectElement);
        select.selectByVisibleText("Three");

        //4)Verify option Label
        Assert.assertEquals("Three", select.getFirstSelectedOption().getText());



    }
}
