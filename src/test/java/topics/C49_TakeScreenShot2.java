package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C49_TakeScreenShot2 extends TestBase {
/*
    Go to Google
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void ssTest(){
//        Go to Google
        driver.get("https://google.com");

//        Take homepage's screenshot
        getFullPageScreenShot();

//        Take logo's screenshot
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));

        getSpecificElementsScreenShot(logo);

    }

}
