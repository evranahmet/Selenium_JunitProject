package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.junit.Assert.assertEquals;

public class C16_RelativeLocator {
/*
    Go to https://clarusway.com/
    Verify that the link on the left of Salesforce is Cybersecurity"
 */
    @Test
    public void relativeLocatorTest(){
        //Go to https://clarusway.com/
        driver.get("https://clarusway.com/");

        //Verify that the link on the left of Salesforce is "Cybersecurity"
        WebElement saleForce = driver.findElement(By.linkText("Salesforce"));
        WebElement cyberSecurity = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(saleForce));
        //Daha kolay locate edilebilen bir web elementi referans alarak onun etrafındaki web elementlere sadece tag name ile ulaşabiliriz.

        String text = cyberSecurity.getText();
        assertEquals("Cybersecurity", text);

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
