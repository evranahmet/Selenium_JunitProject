package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class homeWork09xxx extends TestBase {

    /*
     Go to https://testpages.eviltester.com/styled/calculator
     Do all math operations with different @Test methods
     Get the result
     Verify the result
     Print the result
*/
     @Test
    public void mathPlus(){
         driver.get("https://testpages.eviltester.com/styled/calculator");
         driver.findElement(By.id("number1")).sendKeys("30");
         driver.findElement(By.id("number2")).sendKeys("20");
         driver.findElement(By.id("calculate")).click();
         String sonuc = driver.findElement(By.xpath("//span[@id='answer']")).getText();
         assertEquals("50",sonuc);
         System.out.println("sonuc = " + sonuc);
     }
    @Test
    public void mathTimes() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/calculator");
        WebElement times = driver.findElement(By.id("function"));
        Select select = new Select(times);
        select.selectByIndex(1);
        Thread.sleep(2000);
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("calculate")).click();
        String sonuc = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        assertEquals("20",sonuc);
        System.out.println("sonuc = " + sonuc);
    }
    @Test
    public void mathMinus() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/calculator");
        WebElement minus = driver.findElement(By.id("function"));
        Select select = new Select(minus);
        select.selectByIndex(2);
        Thread.sleep(2000);
        driver.findElement(By.id("number1")).sendKeys("25");
        driver.findElement(By.id("number2")).sendKeys("13");
        driver.findElement(By.id("calculate")).click();
        String sonuc = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        assertEquals("12",sonuc);
        System.out.println("sonuc = " + sonuc);
    }
    @Test
    public void mathDivide() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/calculator");
        WebElement divide = driver.findElement(By.id("function"));
        Select select = new Select(divide);
        select.selectByIndex(3);
        Thread.sleep(2000);
        driver.findElement(By.id("number1")).sendKeys("55");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("calculate")).click();
        String sonuc = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        assertEquals("11",sonuc);
        System.out.println("sonuc = " + sonuc);
    }
}
