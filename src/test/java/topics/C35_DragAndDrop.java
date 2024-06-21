package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C35_DragAndDrop extends TestBase {
    // Go to URL: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @Test
    public void dragAndDropTest() {
        // Go to URL: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Fill in capitals by country.
        //Source
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        //Target
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement usa = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));


        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(oslo, norway)//Birinci parantezde belirtilen wen elemneti, ikinci parantezde belirtilene sürükleyip bırakır.
                .pause(1000)//Sadece actions işlemini bekletir. Thread.sleep() gibi değildir.
                .dragAndDrop(stockholm, sweden)
                .pause(1000)
                .dragAndDrop(washington, usa)
                .pause(1000)
                .dragAndDrop(copenhagen, denmark)
                .pause(1000)
                .dragAndDrop(seoul, korea)
                .pause(1000)
                .dragAndDrop(rome, italy)
                .pause(1000)
                .dragAndDrop(madrid, spain)
                .perform();

    }

}