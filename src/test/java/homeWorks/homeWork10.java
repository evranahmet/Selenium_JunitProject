package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class homeWork10 extends TestBase {
    /*
	Go to https://webdriveruniversity.com/Popup-Alerts/index.html
	Click on JavaScript Alert
	Print alert message
	Accept alert
	Click on JavaScript Confirm Box
	Print alert message
	Cancel alert
	Click on Modal Popup Box
	Print alert message
	Close alert
*/
    @Test
    public void homeWork10() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("button4")).click();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println("alertMessage2 = " + alertMessage2);
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("button2")).click();
        String alertMessage3 = driver.switchTo().alert().getText();
        System.out.println("alertMessage3 = " + alertMessage3);



    }
}
