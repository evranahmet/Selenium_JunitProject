package codeChallenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CH18 extends TestBase {

     /*
    web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
    Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
    "draggable" elementini sürükleyerek sağa doğru 100 piksel hareket ettirin, ardından sola, yukarı ve aşağı yönlere sırasıyla 100 piksel hareket ettirin.
    sürükle ve bırak işlemi sonrasında, "draggable" elementinin yeni konumunu alın ve başlangıç konumuyla karşılaştırın.
    Eğer başlangıç konumuyla aynıysa, bu adım başarılı kabul edilir.
    "draggable" elementini "target" elementine sürükleyin.
    "draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.
    */


    @Test
    public void test() throws InterruptedException {

        //web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");

        // Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
        WebElement draggableElementi = driver.findElement(By.id("draggable"));

        Point ilkKonum = draggableElementi.getLocation();
        //System.out.println("ilkKonum = " + ilkKonum);


        Actions actions = new Actions(driver);

        Thread.sleep(3000);
        actions.dragAndDropBy(draggableElementi, 100, 0)
                .dragAndDropBy(draggableElementi, -100, 0)
                .dragAndDropBy(draggableElementi, 0, 100)
                .dragAndDropBy(draggableElementi, 0, -100)
                .perform();

        Point sonKonum = draggableElementi.getLocation();

        Assert.assertEquals(ilkKonum, sonKonum);

        // "draggable" elementini "target" elementine sürükleyin.
        // "draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.

        WebElement target = driver.findElement(By.id("target"));

        actions.dragAndDrop(draggableElementi, target)
                .perform();

        Assert.assertEquals(draggableElementi.getLocation(), target.getLocation());

    }
}
