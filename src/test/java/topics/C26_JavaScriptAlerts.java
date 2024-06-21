package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C26_JavaScriptAlerts extends TestBase {
    /*
    Alerts: Web sitelerinde iki tür alert bulunmaktadır.
    1. HTML alerts: Sağ tıklayarak incelenebilir ve diğer web elementleri gibi davranır.
    2. JS alerts: Sağ tıklayarak incelenemez, bu nedenle diğer WebElement'lerden farklıdır.

    Interview Sorusu:
    - Alertleri nasıl kullanırsın (handle edersin)?
      driver.switchTo().alert()   bu metotla kullanılır.
      Komutlar:
      accept -> OK, TAMAM yani olumlu butona basmak
      dismiss -> CANCEL, HAYIR yani olumsuz butona basmak
      getText -> Alertin mesajını almak için kullanılır.
      sendKeys -> Alertin inputuna mesaj göndermek için kullanılır.
*/

/*
    Go to URL: https://testpages.eviltester.com/styled/alerts/alert-test.html
    Click on show alert box
    Print alert message on console
    Accept alert
    Click on 'Show confirm box'
    Print alert message on console
    Cancel alert
    Click on Show prompt box
    Type 'Hello World' into alert
    Print the text you sent
*/

    @Test
    public void jsAlertTest() throws InterruptedException {
//Go to URL: https://testpages.eviltester.com/styled/alerts/alert-test.html
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");

//Click on show alert box
        driver.findElement(By.id("alertexamples")).click();//Bu tıklama sonrası alet box açılır.
        //JS Alert açık ikn sayfada işlem yapılamaz!!! --> UnhandledAlertException

//Print alert message on console
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);

//Accept alert
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

//Click on 'Show confirm box'
        driver.findElement(By.id("confirmexample")).click();

//Print alert message on console
        String confirmexample = driver.switchTo().alert().getText();
        System.out.println("confirmexample = " + confirmexample);

//Cancel alert
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

//Click on Show prompt box
        driver.findElement(By.id("promptexample")).click();

//Type 'Hello World' into alert
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();

//Print the text you sent
        Thread.sleep(2000);
        String promptreturn = driver.findElement(By.id("promptreturn")).getText();
        System.out.println("promptreturn = " + promptreturn);
    }
}
