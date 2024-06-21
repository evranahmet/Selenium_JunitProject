package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_Locators {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/index.html");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void locatorsTest() throws InterruptedException {

        //findElement() methodu çoklu bulunana web elementlerinden ilkini verir

        //id örneği
        Thread.sleep(2000);
        WebElement basicpagetest = driver.findElement(By.id("basicpagetest"));//id değeri ile locate ettiğimiz web elementi WebElement containerı içerisine atabiliriz.
        String text = basicpagetest.getText();//locate edilen web element üzerinde getText() methodu uygulandı.
        System.out.println("text = " + text);
        basicpagetest.click();//locate edilen web element üzerinde click() methodu uygulandı.

        //LinkText örneği
        Thread.sleep(2000);
        WebElement index = driver.findElement(By.linkText("Index"));//Index linkini link text'i ile locate ettik
        index.click();//index web elementini tıkladık -> Bu link bizi ana sayfaya götürdü

        //className örneği
              WebElement inlineExplanation = driver.findElement(By.className("inline-explanation"));//inlineExplanation className attribute ile locate edildi
        System.out.println("inlineExplanation = " + inlineExplanation.getText());

        //partialLinkText örneği
        Thread.sleep(2000);
        WebElement locatorLink = driver.findElement(By.partialLinkText("Locators - F"));
        locatorLink.click();

        //name örneği
        WebElement c = driver.findElement(By.name("pName3"));
        System.out.println("c = " + c.getText());

        //tagName örneği
        String h1Tag = driver.findElement(By.tagName("h1")).getText();//WebElement containerına koymadan kullanabiliriz.
        System.out.println("h1Tag = " + h1Tag);

    }


}
