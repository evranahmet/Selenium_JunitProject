package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class C08_XPath {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void absoluteXpathTest() {

        //absoluteXpath sayfadaki değişikliklerden etkileneceği için tercih edilmez.
        WebElement singUpButton = driver.findElement(By.xpath("/html/body/div[3]/button"));
        singUpButton.click();

    }

    @Test
    public void relativeXpathTest() throws InterruptedException {

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailInput.sendKeys("clarusway@hotmail.com");//sendKeys buttona yazılanı girer.

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("Clarusway.123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        Thread.sleep(500);//Click işlemi sonrası sayfa dolmadan alınan title sebeiyle kondu.
        //Assertion yöntemi uygulama ve tester mantığına göre değişebilir
        assertEquals("My Contacts", driver.getTitle());
        assertEquals("https://thinking-tester-contact-list.herokuapp.com/contactList", driver.getCurrentUrl());

    }

    @Test
    public void relativeXpathNegativeTest() throws InterruptedException {

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailInput.sendKeys("XYZ@hotmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("Clarusway.123");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        Thread.sleep(500);//Click işlemi sonrası sayfa dolmadan alınan title sebeiyle kondu.
        WebElement errorMessage = driver.findElement(By.xpath("//span[@id='error']"));
        assertEquals("Incorrect username or password", errorMessage.getText());

    }


}
