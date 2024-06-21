package topics;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.annotation.Target;

public class C02_Junit {

    @Test//Test methodunun başında @Test anatasyonu bulunur
    public void test01() {//Test methodları public ve void'dir
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.quit();


    }
    @Test
    public void test02(){//Junit'te bir class içindeki methodlar alfebetik sıra ile çalışır.
        System.out.println("Test 02");
        WebDriver driver = new ChromeDriver();
        driver.get("http://instagram.com");
        driver.quit();


    }
    @Test
    public void test03(){
        System.out.println("Test 03");
        WebDriver driver = new ChromeDriver();
        driver.get("http://linkedin.com");
        driver.quit();


    }

}
