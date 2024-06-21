package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C40_JavaScriptExecutor extends TestBase {
    //Go to URL: https://api.jquery.com/dblclick/
    //Double-click on the blue square at the bottom of the page and then write the changed color.
    //(mavi kareyi çift tıkla değişen rengi yazdır)

    @Test
    public void jsExecutorTest() throws InterruptedException {
//Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick");
        driver.switchTo().frame(0);//blue square iFrame içinde olduğundan ilgili iFrame switch yapıyoruz.

//Double-click on the blue square at the bottom of the page and then write the changed color.
        WebElement blueSquare = driver.findElement(By.tagName("div"));

        //Tıklama öncesi web element üzerine scroll yapalım: Bunun için javaScriptExecutor'a ihtiyacımız var.
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", blueSquare);

        String colorBeforeClick = blueSquare.getCssValue("background-color");
        System.out.println("colorBeforeClick = " + colorBeforeClick);

        new Actions(driver).pause(2000).doubleClick(blueSquare).perform();

        String colorAfterClick = blueSquare.getCssValue("background-color");
        System.out.println("colorAfterClick = " + colorAfterClick);

        Thread.sleep(3000);
        //Safyayı en üste kaydır:
        driver.switchTo().defaultContent();//driver iFrame içerisinde bulunduğundan scroll işlemi iç sayfada yapılıyor. Bu yüzden dış sayfaya gidiyoruz.
        js.executeScript("window.scrollTo(0, 0)");

        //Sayfayı en dibe kaydır:
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
}
