package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C33_WindowHandle5 extends TestBase {
/*
    Go to https://testpages.eviltester.com/styled/windows-test.html
    Click on Basic Ajax in new page
    Click on Code In
    Assert that submit button is  'Code In It'
*/

    @Test
    public void windowHandleTest() {
//Go to https://testpages.eviltester.com/styled/windows-test.html
        driver.get("https://testpages.eviltester.com/styled/windows-test.html");

//Click on Basic Ajax in new page
        driver.findElement(By.id("gobasicajax")).click();

//Click on Code In
        //1. Yol:
//        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowHandles.get(1));//Driver'ı yeni açılan sayfaya götürür.

        //2. yol:
        String window1Handle = driver.getWindowHandle();
        Set<String> wHandles = driver.getWindowHandles();

        for (String w : wHandles) {
            if (!w.equals(window1Handle)) {//Birinci sayfanın id'sine eşit değilse, yani diğer sayfanın değerine eşitse oraya git.
                driver.switchTo().window(w);
            }
        }

        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();//NoSuchElementException almamak için açılan sayfaya driver'ı götürmeliyiz.

//Assert that submit button is  'Code In It'
        String buttonText = driver.findElement(By.id("_valuesubmitbutton")).getText();
        assertEquals("Code In It", buttonText);

    }

}
