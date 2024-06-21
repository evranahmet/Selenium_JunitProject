package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C14_XpathAxes {
    /*
    Go to https://thinking-tester-contact-list.herokuapp.com/
    Click on submit botton
    Verify error message is 'Incorrect username or password'
     */

    @Test
    public void xpathAxesTest() throws InterruptedException {

        // Go to https://thinking-tester-contact-list.herokuapp.com/
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        //Click on submit botton
        driver.findElement(By.xpath("//form/p[3]/button")).click();

        //Verify error message is 'Incorrect username or password'
        Thread.sleep(200);
        String error = driver.findElement(By.xpath("//span")).getText();
        assert error.equals("Incorrect username or passwordX") : "Error message did not match";//Java assertion
        //assert error.equals("Incorrect username or passwordX");//Java assertion

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
