package topics;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C38_KeyboardActions extends TestBase {
    //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    //In the username section, print "John" by using the action methods.
    //Do not use findElement() method

    @Test
    public void keyboardActionsTest() {

        //Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //In the username section, print "John" by using the action methods.
        Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.TAB)//Tab tuşuna basar çeker
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)//Shift tuşuna basılı tutar
                .sendKeys("j")
                .keyUp(Keys.SHIFT)
                .sendKeys("ohn")
                .sendKeys(Keys.ENTER)
                .perform();

    }

}
