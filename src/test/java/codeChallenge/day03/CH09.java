package codeChallenge.day03;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class CH09 extends TestBase {

     /*
    1) Open the browser
    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
    3)Fill form
    4)Verify alert access 10,danger empty
    */

    @Test
    public void test() {

        //    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

        //    3)Fill form
        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='first-name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='last-name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//input[@name='zip-code']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys(faker.address().country());
        driver.findElement(By.xpath("//input[@name='e-mail']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.xpath("//input[@name='job-position']")).sendKeys(faker.job().position());
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(faker.company().name());

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //    4)Verify alert access 10, danger empty

        List<WebElement> accessList = driver.findElements(By.xpath("//div[@class=\"alert py-2 alert-success\"]"));

        Assert.assertEquals(10, accessList.size());

        List<WebElement> dangerList = driver.findElements(By.xpath("//div[@class=\"alert py-2 alert-danger\"]"));

        Assert.assertTrue(dangerList.isEmpty());

    }


    @Test
    public void actionsClassTest() {

        //    2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");

        //    3)Fill form
        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='first-name']")).sendKeys(faker.name().firstName());
    }

}
