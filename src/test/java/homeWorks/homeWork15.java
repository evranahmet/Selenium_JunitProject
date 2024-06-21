package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class homeWork15 extends TestBase {

    /*
  Go to http://szimek.github.io/signature_pad/
  Draw the line or shape you want on the screen
  Press the clear button after drawing

    // Cikan ekrana istediginiz cizgi yada sekli ciziniz
    WebElement yaziEkrani = driver.findElement(By.xpath("//canvas"));
    Actions actions = new Actions(driver);
        actions.moveToElement(yaziEkrani).clickAndHold();

        for (int i = 0; i < 10; i++) {
        actions.moveByOffset(5,5);
*/
        @Test
        public void canvas() {
            driver.get("http://szimek.github.io/signature_pad/");
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.id("canvas-wrapper"))).clickAndHold();

            for (int i = 0; i < 10; i++) {
                a.moveByOffset(0, 25)
                        .moveByOffset(25, 0)
                        .moveByOffset(0, -20)
                        .moveByOffset(-20, 0).perform();
            }
            WebElement clearButton = driver.findElement(By.xpath("//button[contains(text(), 'Clear')]"));
            clearButton.click();

        }
}
