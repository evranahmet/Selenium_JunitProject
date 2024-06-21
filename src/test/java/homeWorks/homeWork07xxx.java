package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class homeWork07xxx extends TestBase {

    /*
  Go to https://testpages.eviltester.com/styled/find-by-playground-test.html
  Assert that there are 42 web elements with 'p' tag on the page
*/
    @Test
    public void homework07() throws InterruptedException {
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        List<WebElement> pElements = driver.findElements(By.tagName("p"));
        assertEquals(41, pElements.size());

    }
}
