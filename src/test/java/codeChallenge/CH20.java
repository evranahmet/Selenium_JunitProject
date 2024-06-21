package codeChallenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CH20 extends TestBase {

    /*
    // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    // 2. "Hover over Me First" kutusunun ustune gelin
    // 3. "Link 1" e tiklayin
    // 4. Popup mesajini dogrulayin <Well done you clicked on the link!>
    // 5. Popup'i tamam diyerek kapatin
    // 6. "Click and hold" kutusuna basili tutun
    // 7. "Click and hold" kutusunda cikan yaziyi dogrulayin <Well done! keep holding that click now.....>
    // 8. "Double click me" butonunu cift tiklayin
    // 9. "Double click me" butonunun renk değiştridiğini doğrulayın
     */


    @Test
    public void test() {

        // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOver1Button = driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[1]"));
        actions.moveToElement(hoverOver1Button).perform();

        // 3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class=\"list-alert\"])[1]")).click();

        // 4. Popup mesajini dogrulayin <Well done you clicked on the link!>
        String popupText = driver.switchTo().alert().getText();
        Assert.assertEquals("Well done you clicked on the link!", popupText);

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();


        // 7. "Click and hold" kutusunda cikan yaziyi dogrulayin <Well done! keep holding that click now.....>
        Assert.assertEquals("Well done! keep holding that click now.....", clickAndHold.getText());

        // 8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.id("double-click"));

        //System.out.println(doubleClick.getAttribute("class"));
        //System.out.println(doubleClick.getCssValue("background-color"));

        String backgroundOncesi = doubleClick.getCssValue("background-color");

        actions.doubleClick(doubleClick).perform();

        // 9. "Double click me" butonunun renk değiştridiğini doğrulayın

        //System.out.println(doubleClick.getAttribute("class"));
        //System.out.println(doubleClick.getCssValue("background-color"));

        String backgroundSonrasi = doubleClick.getCssValue("background-color");

        Assert.assertNotEquals(backgroundOncesi, backgroundSonrasi);

    }
}
