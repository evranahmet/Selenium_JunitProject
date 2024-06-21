package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C23_MultipleDropDown extends TestBase {
/*
        Open "https://testpages.herokuapp.com/styled/basic-html-form-test.html".
        Locate the 'Multiple Select Values' element.
        Verifying that the element is multi-select.
        Select 'Selection Item 3' using the index and deselect the same using index.
        Select 'Selection Item 1' using visible text and deselect the same using value.
        Select all items using the index .
        Deselect all the options.
*/

    @Test
    public void mulDropdown() throws InterruptedException {
//Open "https://testpages.herokuapp.com/styled/basic-html-form-test.html"
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//Locate the 'Multiple Select Values' element.
        WebElement multipleDropDown = driver.findElement(By.xpath("//select[@multiple='multiple']"));

//Verifying that the element is multi-select.//Doğrulama yapma
        Select select = new Select(multipleDropDown);
        boolean isMultiple = select.isMultiple();
        assert isMultiple;//Java assertion

//Select 'Selection Item 3' using the index and deselect the same using index.
        Thread.sleep(3000);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.deselectByIndex(2);

//Select 'Selection Item 1' using visible text and deselect the same using value.
        Thread.sleep(3000);
        select.selectByVisibleText("Selection Item 1");
        Thread.sleep(3000);
        select.deselectByVisibleText("Selection Item 1");

//Select all items using the index .
        Thread.sleep(1000);
        select.selectByIndex(0);
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.selectByIndex(3);

//Deselect all the options.
        Thread.sleep(3000);
        select.deselectAll();
    }
}
