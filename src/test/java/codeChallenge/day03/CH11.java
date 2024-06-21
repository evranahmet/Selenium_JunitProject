package codeChallenge.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class CH11 extends TestBase {

    /*
     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
     Launch alert buttonuna tıklayın
     Alert pop-up textin <Hello world!> olduğunu doğrulayın
    */

    @Test
    public void testAlert() {
        // switchTo ile

        //     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

        //     Launch alert buttonuna tıklayın
        driver.findElement(By.id("my-alert")).click();

        //     Alert pop-up textin <Hello world!> olduğunu doğrulayın
        String alertText = driver.switchTo().alert().getText();

        Assert.assertEquals("Hello world!", alertText);
        //driver.switchTo().alert().accept();
    }

    @Test
    public void testAlert2() {
        // wait until ile

        //     https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

        //     Launch alert buttonuna tıklayın
        driver.findElement(By.id("my-alert")).click();

        //     Alert pop-up textin <Hello world!> olduğunu doğrulayın
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("Hello world!", alert.getText());


    }
}
