package topics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C18_ChromeOptions {
/*
 ChromeOptions Class

    Selenium WebDriver'da Chrome sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.
    start-maximized: Chrome'u büyütme modunda açar.
    incognito: Chrome'u gizli modda açar.
    --headless: Chrome'u görüntülenmeyen modda çalıştırır.(headless modda)
    disable-extensions: Chrome tarayıcısında mevcut uzantıları devre dışı bırakır.
    disable-popup-blocking: Chrome tarayıcısında görüntülenen açılır pencereleri devre dışı bırakır.
    make-default-browser: Chrome'u varsayılan tarayıcı yapar.
    version: Chrome tarayıcı sürümünü yazdırır.
    disable-infobars: Chrome'un "Chrome otomatik yazılım tarafından kontrol ediliyor" bildirimini görüntülemesini engeller.
    --disbale-cookies: Cookie'leri(Çerezleri) engeller
 */


    @Test
    public void chromeOptionsTest() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");-->Chrome'u görüntülenmeyen modda çalıştırır.(headless modda)
        chromeOptions.addArguments("start-maximized");//Chrome'u büyütme modunda açar.
        chromeOptions.addArguments("incognito");//Chrome'u gizli modda açar.
        chromeOptions.addArguments("--disbale-cookies");//Cookie'leri(Çerezleri) engeller

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://linkedin.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();

    }

}
