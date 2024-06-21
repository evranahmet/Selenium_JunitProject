package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C20_RadioButton extends TestBase {
//Radio Button: Gruplanmış seçeneklerden sadece birinin seçilebildiği girdilerdir.

/*
    Go to URL:  http://test.rubywatir.com/radios.php
    Then click on the radio button 'radio with id'
    Assert radio button 'radio with id' is selected and radio button 1 is not selected
*/
    @Test
    public void radioButtonTest(){
//        Go to URL:  http://test.rubywatir.com/radios.php
        driver.get("http://test.rubywatir.com/radios.php");

//        Then click on the radio button 'radio with id'
        WebElement radioId = driver.findElement(By.id("radioId"));
        radioId.click();

//        Assert radio button 'radio with id' is selected and radio button 1 is not selected
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='Radio1']"));

        assertTrue(radioId.isSelected() && !radio1.isSelected());

    }


}
