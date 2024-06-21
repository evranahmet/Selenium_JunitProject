package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_BeforeClassAfterClass {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        System.out.println("Before Class Methodu");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown() throws InterruptedException {
        System.out.println("After Class Methodu");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test01() {
        System.out.println("test01");
        driver.get("https://google.com");
    }

    @Test
    public void test02()  {
        System.out.println("test02");
        driver.get("https://linkedin.com");

    }
    @Test
    public void test03() {
        System.out.println("test03");
        driver.get("https://instagram.com");

    }

}
