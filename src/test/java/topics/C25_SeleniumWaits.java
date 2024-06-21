package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class C25_SeleniumWaits {
/*
        Implicit Wait  ve Explicit Wait

Implicit: Bütün elemanlar için kullanılır ve bir kere tanımlanır.
Explicit: Tek bir eleman özel kriter olarak tanımlanır, sadece ilgili elemanda geçerlidir.

Her ikisi tanımlı ise: Önce Implicit kullanılır ve üzerine Explicit'in süresi eklenerek toplam hata sınırı süresi ortaya çıkar.
Selenium waits (senkronizasyon): Kodlarımızı, internet ve bilgisayarın çalışmasını uyumlu hale getirmek için bazen kodlarımızı bekletmemiz gerekir.
    - Thread.sleep(): Java'dan gelir ve kodları durdurur. Kendisine verilen sürenin tamamını bekler. Dinamik değil, statiktir.

    implicitlyWait: Selenium'dan gelir. Sayfanın yüklenmesi ve her bir WebElement'in locate edilmesi için beklenecek maksimum süreyi belirler. Esnektir. Esas olan beklemek değil, kodun çalışmasını sağlamaktır. Kod çalışırsa beklemeden devam eder, çalışmazsa maksimum süre doluncaya kadar bekler ve sonra hata mesajı verir (Exception).

    explicitlyWait: Selenium'dan gelir ve belirli bir işlem için beklenecek maksimum süreyi belirler. ExplicitlyWait kullanabilmek için wait objesi oluşturmamız gerekir.
    - wait.until(expectedConditions… İstediğimiz fonksiyon) şeklinde kullanılır. Genellikle wait.until() method'u locate ile birlikte kullanılır.

    ExpectedConditions:
    - .titleIs -> Başlık bu olana kadar bekle
    - .titleContains -> Başlıkta bu kelime geçene kadar bekle
    - .visibilityOfTheElement -> Eleman görünür olana kadar bekle
    - .elementToBeClickable -> Eleman tıklanabilir olana kadar bekle
    - .elementToBeSelected -> Eleman seçilebilir olana kadar bekle
    - .alertIsPresent() -> Alert çıkana kadar bekle
    - .textToBe -> Elemanda verilen metin gözükene kadar bekle
    - .invisibilityOfTheElement -> Eleman kaybolana kadar bekle
 */

    @Test
    public void pageLoadTest() {//sayfa için bekleme süresi
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Belirlenen sürede safya yüklenmezse TimeoutException atar.
        driver.get("https://seleniumatfingertips.wordpress.com/");
        driver.findElement(By.partialLinkText("Group Test in TestNG")).click();
        assertEquals("Group Test in TestNG | Selenium at Fingertips", driver.getTitle());
    }

    @Test
    public void implicitWaitTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //10 saniyeye kadar elementin bulunmasını bekler. Eğer daha önce bulunursa beklemeyi durudurur.
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.id("OlmayanID")).click();//10 saniye sonra NoSuchElementException atar.
        driver.quit();
    }

    @Test
    public void explicitWatTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(By.id("submit")).click();

        String errorMessage = driver.findElement(By.id("error")).getText();
        System.out.println("errorMessage Before Wait: " + errorMessage);
        //implicitlyWait kullanılmasına rağmen wen element bulundu fakat boş text döndü.

        //Web elementin görünür olana kadar beklenebilmesi için WebDriverWait(Explicit Wait) kullanacağız.
        //WebDriverWait(Explicit Wait) web elementlere (her birine) özel olarak kullanılır.

        //1. Adım: WebDriverWait objesi oluştur.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //2. Adım until methodunu istediğimiz koşul methodu ile kullan.
        String errorMessageAfterWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error"))).getText();
        System.out.println("errorMessageAfterWait = " + errorMessageAfterWait);

        assertEquals("Incorrect username or password", errorMessageAfterWait);

        driver.quit();

    }

    @Test
    public void fluentWaitTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
        driver.findElement(By.xpath("//button[.='Click Me - Fluent Wait']")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))//Toplam bekleme süresi
                .pollingEvery(Duration.ofSeconds(3))//Her 3 saniye bir yeniden elementi ara
                .ignoring(NoSuchElementException.class);//Ignore olacak exception

        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Software Testing Material - DEMO PAGE']"))).getText();
        System.out.println("message = " + message);
        assertEquals("Software Testing Material - DEMO PAGE", message);

        Thread.sleep(3000);
        driver.quit();
    }

}
