package homeWorks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class homeWork04xxx {
    /*
     Create chrome driver object by using @Before annotation
     Navigate to  https://testpages.herokuapp.com/styled/index.html
     Click on  Calculator under Micro Apps
     Type any number in the first input
     Type any number in the second input
     Click on Calculate
     Get the result
     Verify the result
     Print the result
     Close the browser by using @After annotation
*/
    @Test
    public void beforeAnnotation() throws InterruptedException {

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement no1 = driver.findElement(By.id("number1"));
        no1.sendKeys("20");
        Thread.sleep(2000);
        WebElement no2 = driver.findElement(By.id("number2"));
        no2.sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.id("calculate")).click();
        String sonuc = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        assertEquals("30",sonuc);
        System.out.println("sonuc = " + sonuc);


//Get the result

    }
    static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
