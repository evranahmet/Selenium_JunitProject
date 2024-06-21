package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class homeWork12 extends TestBase {

    /*
    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    Click all the buttons and verify they are all clicked
*/
    //Rooney Hocam
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        clickElement(By.id("onblur"));
        Actions a =new Actions(driver);
        a.click().perform();
        AssertText(By.id("onblurstatus"),"Event Triggered");
        clickElement(By.id("onclick"));
        AssertText(By.id("onclickstatus"),"Event Triggered");
        a.contextClick(driver.findElement(By.id("oncontextmenu"))).perform();
        AssertText(By.id("oncontextmenustatus"),"Event Triggered");
        a.doubleClick(driver.findElement(By.id("ondoubleclick"))).perform();
        AssertText(By.id("ondoubleclickstatus"),"Event Triggered");
        clickElement(By.id("onfocus"));
        AssertText(By.id("onfocusstatus"),"Event Triggered");
    }
    public void clickElement(By element){
        driver.findElement(element).click();
    }
    public void AssertText(By element, String text){
        Assert.assertTrue(driver.findElement(element).getText().equals(text));
    }
}
