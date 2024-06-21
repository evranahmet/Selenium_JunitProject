package codeChallenge;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class CH17 extends TestBase {

    // Step 1: Go to the URL -> https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
    // accept cookies (cikanlar icin) =>  driver.findElement(By.id("accept-choices")).click();
    // Step 2: Switch to the iframe containing the "Try it" button
    // Locate and click the "Try it" button
    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle

    @Test
    public void test() {

        // Step 1: Go to the URL -> https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        // accept cookies (cikanlar icin) =>  driver.findElement(By.id("accept-choices")).click();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        // Step 2: Switch to the iframe containing the "Try it" button

        WebElement iframeElement = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframeElement);


        // Locate and click the "Try it" button
        driver.findElement(By.xpath("//button[.='Try it']")).click();

        // Step 3: Switch to the new window that opened
        for (String windowHandle : driver.getWindowHandles()) {

            driver.switchTo().window(windowHandle);

            String windowUrl = driver.getCurrentUrl();
            System.out.println("windowUrl = " + windowUrl);

            String windowTitle = driver.getTitle();
            System.out.println("windowTitle = " + windowTitle);

            // Step 4: Switch back to the original window by using the window handle
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }

    }
}
