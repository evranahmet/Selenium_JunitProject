package topics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriver {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();//Selenium 4.6 öncesi driver direkt oluşturulamıyordu. WebDriverManager yardımı ile direkt oluşturulabilirdi.
        driver.manage().window().maximize();

        driver.get("https://clarusway.com");

        if (driver.getTitle().contains("Bootcamp")) {//Bu yöntem ile test işlemi yapılmaz. Bit test framework'ü yükleyeceğiz.
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.quit();

    }
}
