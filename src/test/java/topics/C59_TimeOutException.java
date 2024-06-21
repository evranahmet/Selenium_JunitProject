package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C59_TimeOutException extends TestBase {

    @Test
    public void test1() {

        driver.get("https://linkedin.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Explicit wait kullanıldığında element belirtilen sürede bulanamazsa TimeoutException atar.
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xyz")));//TimeoutException

        System.out.println(element.getText());

    }

    @Test
    public void test2(){

        driver.get("https://google.com");

        waitAndLocate(By.name("X")).sendKeys("Hello World"+ Keys.ENTER);

    }

}
