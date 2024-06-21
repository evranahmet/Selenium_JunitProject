package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C32_WindowHandle4 extends TestBase {
/*
        Open https://www.google.com/ in the opened tab
        Create a new tab
        Open https://www.linkedin.com/ in the opened tab
        Create a new window
        Open https://clarusway.com/ in the opened window
        Switch to the LinkedIn tab and write 'You found the LinkedIn tab' in the email area
*/

    @Test
    public void windowHandleTest() {
//Open https://www.google.com/
        driver.get("https://www.google.com");

//Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);

//Open https://www.linkedin.com/ in the opened tab
        driver.get("https://www.linkedin.com");

//Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);

//Open https://clarusway.com/ in the opened window
        driver.get("https://clarusway.com");

//Switch to the LinkedIn tab and write 'You found the LinkedIn tab' in the email area
        List<String> wHandles = new ArrayList<>(driver.getWindowHandles());//set i array listin içine alırız
        String linkedInWindowHandle = wHandles.get(1);

        driver.switchTo().window(linkedInWindowHandle);

        driver.findElement(By.id("session_key")).sendKeys("You found the LinkedIn tab");

    }

}
