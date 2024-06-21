package homeWorks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeWork06xxx {
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
        /*
    Go to http://test.rubywatir.com/ifelse.php
    Click the correct submit button declared in the yellow line
    Finish the test after 50 correct click
*/
    }
    @Test
    public void ifElseHomework() throws InterruptedException {
//        Go to http://test.rubywatir.com/ifelse.php
        driver.get("http://test.rubywatir.com/ifelse.php");

        for (int i = 0; i <50 ; i++) {
            if (driver.findElement(By.id("buttonNumber"))==driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=1']"))){
                driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=1']")).click();
                Thread.sleep(200);

            } else if (driver.findElement(By.id("buttonNumber"))==driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=2']"))) {
                driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=2']")).click();
                Thread.sleep(200);

            }else if (driver.findElement(By.id("buttonNumber"))==driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=3']"))) {
                driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=3']")).click();
                Thread.sleep(200);

            }else if (driver.findElement(By.id("buttonNumber"))==driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=4']"))) {
                driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=4']")).click();
                Thread.sleep(200);

            }else if (driver.findElement(By.id("buttonNumber"))==driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=5']"))) {
                driver.findElement(By.xpath("//form[@action='/ifelse.php?randno=3&noclicked=5']")).click();
                Thread.sleep(200);
            }
            System.out.println("i = " + i);

        }


    }
    //2. yol Rooney Hocam
    @Test
    public void test01(){
        driver.get("http://test.rubywatir.com/ifelse.php");
        for (int i = 0; i <50 ; i++) {

            String index= GetText(By.id("buttonNumber"));
            driver.findElement(By.xpath("(//div[@id='formbuttons']//td//input)["+index+"]")).click();
            String correctButton=driver.findElement(By.id("passed")).getText();
            Assert.assertEquals("You clicked the correct button", correctButton);
            System.out.println(i);
        }
    }
    public String GetText(By element){
        return driver.findElement(element).getText();
    }
}
