package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


public class C06_AssertionTest {
    /*
    Go to Clarusway homepage "https://clarusway.com/"
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains clarusway.
    2- Test if the title does not contain Facebook.
    3- Test if the URL equals to "https://clarusway.com/"
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


    @Test//Test if the URL contains clarusway.
    public void urlContainsTest() {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("clarusway"));
    }

    @Test//Test if the title does not contain Facebook.
    public void titleTest() {
        assertFalse(driver.getTitle().contains("Facebook"));
    }

    @Test//Test if the URL equals to "https://clarusway.com/"
    public void urlEqualsTest() {
        assertEquals("https://clarusway.com/", driver.getCurrentUrl());
    }
}
