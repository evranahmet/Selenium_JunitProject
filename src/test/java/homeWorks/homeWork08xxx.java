package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class homeWork08xxx extends TestBase {

    /*
Go to URL: https://app.endtest.io/guides/docs/how-to-test-checkboxes/
Select all checkboxes
Assert that they are all selected
 */
    @Test
    public void checkBox(){
        driver.get("https://app.endtest.io/guides/docs/how-to-test-checkboxes/");
        WebElement checkBox1 = driver.findElement(By.id("pet1"));
        WebElement checkBox2 = driver.findElement(By.id("pet2"));
        WebElement checkBox3 = driver.findElement(By.id("pet3"));

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }
        assertTrue(checkBox1.isSelected()&&checkBox2.isSelected()&&checkBox3.isSelected());


    }
}
