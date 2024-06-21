package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class C47_FileUploadRobotClass extends TestBase {
    /*
    Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    Find the path of the file that you want to upload.
    Click on Upload button.
    Verify the upload message.
*/

    @Test
    public void uploadTest() throws AWTException, InterruptedException {
//        Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//        Find the path of the file that you want to upload.
        WebElement fileInput = driver.findElement(By.xpath("(//td)[4]"));
        fileInput.click();
        Thread.sleep(1000);

        //Upload edilecek dosyanın yolunu panoya kopyalayalım:
        StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\Addresses.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//kopyala

        Robot robot = new Robot();

        //CTRL+V --> Bas
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //CTRL+V --> Kaldır: UNUTMA!!!
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);

        //ENTER --> Bas
        robot.keyPress(KeyEvent.VK_ENTER);
        //ENTER --> Çek
        robot.keyRelease(KeyEvent.VK_ENTER);

//        Click on Upload button.
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='submit']")).click();

//        Verify the upload message.
        String uploadMessage = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("Addresses.txt", uploadMessage);

    }

}
