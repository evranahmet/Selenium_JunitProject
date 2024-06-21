package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C12_LocatorPractice03 {
    /*
        Navigate to website  https://testpages.herokuapp.com/styled/index.html
        Under the Examples
        Click on Locators - Find By Playground Test Page
        Print the URL
        Navigate back
        Print the URL
        Click on WebDriver Example Page
        Print the URL
        Enter value  20 and Click on "Process On Server"
        And then verify 'two, zero' message is displayed
        Close driver.
    */
    @Test
    public void test01() {

//        Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//        Under the Examples Click on Locators - Find By Playground Test Page
        driver.findElement(By.id("findbytest")).click();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Navigate back
        driver.navigate().back();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Click on WebDriver Example Page
        driver.findElement(By.partialLinkText("WebDriver Exa")).click();

//        Print the URL
        System.out.println(driver.getCurrentUrl());

//        Enter value  20 and Click on "Process On Server"
        driver.findElement(By.id("numentry")).sendKeys("20");// + Keys.ENTER da yapabilirsiniz
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        And then verify 'two, zero' message is displayed
        String message = driver.findElement(By.id("message")).getText();
        System.out.println("message = " + message);
        assertEquals("two, zero", message);

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
