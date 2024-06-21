package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class homeWork14 extends TestBase {

    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
  */
    @Test
    public void boxes(){
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions a = new Actions(driver);
        a.dragAndDrop(driver.findElement(By.id("fourth")),driver.findElement(By.id("amt7"))).
                dragAndDrop(driver.findElement(By.id("fourth")),driver.findElement(By.id("amt8"))).
                dragAndDrop(driver.findElement(By.id("credit2")),driver.findElement(By.id("bank"))).
                dragAndDrop(driver.findElement(By.id("credit1")),driver.findElement(By.id("loan"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='table4_result']")).isDisplayed());
    }
}
