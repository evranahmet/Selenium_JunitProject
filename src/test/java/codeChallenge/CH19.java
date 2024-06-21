package codeChallenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CH19 extends TestBase {

    /*
    web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
    Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın.
    görüntünün üzerine gelin ve görünen yazıyı alın.
    Bu yazının, "Compass" olup olmadığını doğrulayın.
    İkinci görüntünün üzerine gelin ve görünen yazıyı alın.
    Bu yazının, "Calendar" olup olmadığını doğrulayın.
    Sira ile Üçüncü goruntu "Award" ve dördüncü goruntu icin "Landscape", aynı işlemleri tekrarlayın.
*/


    @Test
    public void test() throws InterruptedException {

        // web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        // Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın.
        List<WebElement> images = driver.findElements(By.xpath("//*[@class=\"figure text-center col-3 py-2\"]"));

        // görüntünün üzerine gelin ve görünen yazıyı alın.

        List<String> expectedText = new ArrayList<>(List.of("Compass", "Calendar", "Award", "Landscape"));

        List<WebElement> actualText = driver.findElements(By.xpath("//*[@class='lead py-3']"));


        Actions actions = new Actions(driver);

        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).perform();

            Assert.assertEquals(expectedText.get(i), actualText.get(i).getText());

        }


    }
}
