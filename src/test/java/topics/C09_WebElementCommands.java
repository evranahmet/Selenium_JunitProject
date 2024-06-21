package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class C09_WebElementCommands {
// sendKeys(String keys) methodu: Elementimize klavyeyle yazılmış gibi değer gönderir.
// isDisplayed() methodu: Elementin sayfada görüntülenip görüntülenmediğini boolean olarak döndürür.
// isSelected() methodu: Elementin seçili olup olmadığını bilgisini verir (checkbox, radio).
// isEnabled() methodu: Bir elementin aktif olup olmadığını bilgisini verir (button ve girdi yapılan elementlerde kullanılabilir).
// submit() methodu: Formları göndermemize yardımcı olur, ENTER tuşunun görevini görür.
// click() methodu: Bir elemente sol tıklamamızı sağlar.
// getLocation() methodu: Elementin konumunu bize verir.
// clear() methodu: Input alanlarındaki yazıları temizler.
// getText() methodu: Elementin text içeriğini bize verir.
// getAttribute(String key) methodu: Elementin istediğimiz özellik değerini getirir.
// getSize() methodu: Elementin boyutunu bize verir.

/*
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    Fill username, password and TextArea Comment
    Cancel butonunun görünür olup olmadığını isDisplayed() methodu ile yazdırınız.
*/

    @Test
    public void webElementCommandsTest(){

//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill username, password and TextArea Comment
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("john_doe");

        WebElement password  = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123");

        WebElement comments = driver.findElement(By.xpath("//textarea[@name='comments']"));
        comments.clear();//hazır bulunan text'i temizler
        comments.sendKeys("Hello this is a user");

//        Cancel butonunun görünür olup olmadığını isDisplayed() methodu ile yazdırınız.
        WebElement cancel = driver.findElement(By.xpath("//input[@type='reset']"));
        boolean isDisplayed = cancel.isDisplayed();
        System.out.println("isDisplayed = " + isDisplayed);//true mu false mu?
        assertTrue(isDisplayed);//test geçer mi?

    }

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
