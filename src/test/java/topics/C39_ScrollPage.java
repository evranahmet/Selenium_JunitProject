package topics;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C39_ScrollPage extends TestBase {
    /*
    Go to "https://linkedin.com"
    Scroll page down with 'page down' key
    Scroll page down with 'down arrow' key
    Scroll page up with 'page up' key
    Scroll page up with 'up arrow' key
     */

    @Test
    public void scrollTest(){
//Go to "https://linkedin.com"
        driver.get("https://linkedin.com");

//Scroll page down with 'page down' key
//Scroll page down with 'down arrow' key
//Scroll page up with 'page up' key
//Scroll page up with 'up arrow' key
        new Actions(driver)
                .sendKeys(Keys.PAGE_DOWN)//PAGE_DOWN tuşu ile sayfa aşağıya çok kaydırılır.
                .pause(2000)
                .sendKeys(Keys.ARROW_DOWN)//ARROW_DOWN tuşu ile sayfa aşağıya az kaydırılır.
                .pause(2000)
                .sendKeys(Keys.PAGE_UP)
                .pause(2000)
                .sendKeys(Keys.ARROW_UP)
                .perform();
    }

}
