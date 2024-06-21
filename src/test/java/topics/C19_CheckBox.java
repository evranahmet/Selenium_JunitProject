package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C19_CheckBox extends TestBase {//TestBase extends yaparak ulaşabiliyoruz

/*
    Go to https://the-internet.herokuapp.com/checkboxes
    Locate the elements of checkboxes.
    Then click on checkbox 1 if box is not selected.
    Then click on checkbox 2 if box is not selected.
    Then verify that checkbox 1 and checkbox 2 are checked.
 */

    @Test
    public void checkBoxTest() {

//        Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//        Locate(yerini belirle) the elements of checkboxes.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

//        Then click on checkbox 1 if box is not selected.-->>isSelected() seçiliyse true değilse false döner
        if (!checkBox1.isSelected()) {//checkBox1 seçili değilse
            checkBox1.click();
        }

//        Then click on checkbox 2 if box is not selected.
        if (!checkBox2.isSelected()) {//checkBox1 seçili değilse
            checkBox2.click();
        }

//        Then verify that checkbox 1 and checkbox 2 are checked.

        assertTrue(checkBox1.isSelected() && checkBox2.isSelected());

    }
}
