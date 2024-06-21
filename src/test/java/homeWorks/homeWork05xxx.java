package homeWorks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class homeWork05xxx {
    /*
    Go to https://thinking-tester-contact-list.herokuapp.com/
    Create a user
    Sing in Application
    Add 5 contacts
 */
    @Test
    public void addUser() throws InterruptedException {

        //  Create a user
        driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");
       driver.findElement(By.id("signup")).click();

//        Sing in Application
        driver.findElement(By.id("firstName")).sendKeys("aaa");
        driver.findElement(By.id("lastName")).sendKeys("bbb");
        driver.findElement(By.id("email")).sendKeys("gfd6rresdf@gmail.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);

//        Add 5 contacts
        driver.findElement(By.xpath("//button[@id='add-contact']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Ahmet");
        driver.findElement(By.id("lastName")).sendKeys("Evran");
        driver.findElement(By.id("birthdate")).sendKeys("1985/03/24");
        driver.findElement(By.id("email")).sendKeys("ahmt.evrn.64@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("street1")).sendKeys("Kemalöz Mahallesi");
        driver.findElement(By.id("city")).sendKeys("Uşak");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//button[@id='add-contact']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Ayşe");
        driver.findElement(By.id("lastName")).sendKeys("def");
        driver.findElement(By.id("birthdate")).sendKeys("1970/04/11");
        driver.findElement(By.id("email")).sendKeys("def@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("street1")).sendKeys("def Mahallesi");
        driver.findElement(By.id("city")).sendKeys("İzmir");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//button[@id='add-contact']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Mehmet");
        driver.findElement(By.id("lastName")).sendKeys("ghı");
        driver.findElement(By.id("birthdate")).sendKeys("1990/11/21");
        driver.findElement(By.id("email")).sendKeys("ghı@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("street1")).sendKeys("ghı Mahallesi");
        driver.findElement(By.id("city")).sendKeys("Manisa");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//button[@id='add-contact']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Emre");
        driver.findElement(By.id("lastName")).sendKeys("jkl");
        driver.findElement(By.id("birthdate")).sendKeys("1980/09/12");
        driver.findElement(By.id("email")).sendKeys("jkl@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("street1")).sendKeys("jkl Mahallesi");
        driver.findElement(By.id("city")).sendKeys("İstanbul");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();

        driver.findElement(By.xpath("//button[@id='add-contact']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Büşra");
        driver.findElement(By.id("lastName")).sendKeys("mno");
        driver.findElement(By.id("birthdate")).sendKeys("1950/05/04");
        driver.findElement(By.id("email")).sendKeys("mno@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("street1")).sendKeys("mno Mahallesi");
        driver.findElement(By.id("city")).sendKeys("Giresun");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);



}



    static WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
