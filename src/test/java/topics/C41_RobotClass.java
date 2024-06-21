package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class C41_RobotClass extends TestBase {
/*
    Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
    Copy h1 element's text and paste it into username input
    Click enter
    Scroll page down
    Scroll page up
    (Don't use click() and sendKeys() methods)
 */
    @Test
    public void robotClassTest() throws AWTException, InterruptedException {
//Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//Copy h1 element's text and paste it into username input
        String h1 = driver.findElement(By.tagName("h1")).getText();
        System.out.println("h1 = " + h1);

        StringSelection ss = new StringSelection(h1);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//Bu 2 satırda h1 text'ini panoya kopyaladık.

        Robot robot = new Robot();

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);//Bu 2 satırda tab tuşuna basılıp çekilir.
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        //CTRL+V ile panodaki String değeri yapıştıralım:
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);//Bu iki satır => CTRL + V
        //Bastığımız tuşları kaldrımayı unutmayalım!!!
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //Click enter
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);//Bu 2 satırda Enter tuşuna basılıp çekilir
        Thread.sleep(3000);

//Scroll page down
        robot.mouseWheel(3);//mouse tekerleği 3 kere aşağı

//Scroll page up
        Thread.sleep(3000);
        robot.mouseWheel(-2);//mouse tekerleği yukarı kaydır

    }

}
