package homeWorks;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class homeWork03xxx {
    /*
Go to Clarusway homepage
Do the following tasks by creating 3 different test methods.
Check if the URL contains clarusway.
Check if the title does not contain Python.
Check if the title equals to "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce"
 */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://clarusway.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
//    Do the following tasks by creating 3 different test methods.
    @Test//    Check if the URL contains clarusway.
    public void urlContainsTest() {
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        Assert.assertTrue(url.contains("clarusway"));
    }

    @Test//Check if the title does not contain Python.
    public void notContainPython(){
        String title = driver.getTitle();
        System.out.println("title = " + title);
        Assert.assertFalse(title.contains("Python"));

    }
    @Test//Check if the title equals to "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce"
   public void equals() {
        String title2 = driver.getTitle();
        System.out.println("title2 = " + title2);
        assertEquals(title2, "Online IT Bootcamp; Learn Coding, Data Science, AWS, DevOps, Cyber Security & Salesforce");
    }

}
