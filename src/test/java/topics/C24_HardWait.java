package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;


import static org.junit.Assert.assertEquals;

public class C24_HardWait extends TestBase {
//Hard Wait --> Java Wait --> Java'nın çalışmasını bir süreliğine bekletir.
//Zaman tabanlı senkronizasyon - Statik bekleme
//Statik bekleme, belirli bir süre boyunca beklemeyi temsil eder
//Ve yalnızca belirtilen süre dolduğunda işlemin devam etmesini sağlar
//Java ile Selenium'da statik bekleme sağlamak için Thread.sleep() yöntemini kullanırız

/*
    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
    Click on Ajax Loader
    Click on 'Click Me'
    Assert text "Well Done For Waiting....!!!"
*/

    @Test
    public void hardWaitTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();//TestBase'de bulunan driver implicit wait içerdiği için kendi drivier'ımızı oluşturuyoruz.
        driver.manage().window().maximize();

//        Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");

//        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();

//        Click on 'Click Me'
        Thread.sleep(5000);//Element'in kullanılabilir olabilmesi için 5 saniye beklenmesi gerekmetedir.
        //Hard Wait(Java Wait) zorunlu olmadıkça önerilmez. Çünkü element erken de yüklense belirlenen zaman kadar çalışma durur. Vakit kaybına sebep olur.
        driver.findElement(By.id("button1")).click();

//        Assert text "Well Done For Waiting....!!!"
        Thread.sleep(500);
        assertEquals("Well Done For Waiting....!!!", driver.findElement(By.tagName("h4")).getText());

        Thread.sleep(2000);
        driver.quit();

    }


}
