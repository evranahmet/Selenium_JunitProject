package topics;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C10_LocatorPractice01 {
    /*
        Create the driver with BeforeClass and make it static inside the class.
        Go to http://www.google.com
        Type "Green Mile" in the search box and print the number of results.
        Type "Premonition" in the search box and print the number of results.
        Type "The Matrix" in the search box and print the number of results.
        Close with AfterClass.
     */

    private WebDriver driver;
    WebElement searchBox;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        searchBox = driver.findElement(By.name("q"));
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.findElement(By.id("hdtb-tls")).click();//google da tools(araçlar) kısmına gider arama sonuç sayısını verir
        System.out.println(driver.findElement(By.id("result-stats")).getText());
        Thread.sleep(3000);
        driver.quit();
    }

    @Test//"Green Mile"
    public void test01() throws InterruptedException {
        searchBox.sendKeys("Green Mile" + Keys.ENTER);//+ Keys.ENTER girilen String sonrası Enter tuşuna basar
    }

    @Test//"Premonition"
    public void test02() {
        searchBox.sendKeys("Premonition" + Keys.ENTER);
    }

    @Test//"The Matrix"
    public void test03() {
        searchBox.sendKeys("The Matrix" + Keys.ENTER);
    }

}
