package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C60_StaleElementReferenceException extends TestBase {

    @Test
    public void test1(){

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        WebElement signup = driver.findElement(By.id("signup"));
        signup.click();

        driver.get("https://google.com");

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        //İlk sayfada locate edilen elementin referansı eskidi.
        //Tekrar locate edilmeden aynı web element kullanılırsa StaleElementReferenceException atar.
        //Çözüm : Tekrar locate et:
        // signup = driver.findElement(By.id("signup"));

        signup.click();//StaleElementReferenceException

    }

    @Test
    public void test2(){

        driver.get("https://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        driver.navigate().refresh();//Refresh yapılınca önceki locate edilen web elementlerin referansları eskir.

        //Çözüm: Relocate --> searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("Clarusway"+ Keys.ENTER);//StaleElementReferenceException

    }

}
