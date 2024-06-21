package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C46_FileUpload extends TestBase {
/*
    Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
    Find the path of the file that you want to upload.
    Click on Upload button.
    Verify the upload message.
*/

    @Test
    public void uploadTest() {
//        Go to URL: https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

//        Find the path of the file that you want to upload.
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(System.getProperty("user.home") + "/Desktop/Flower.bmp");

//        Click on Upload button.
        driver.findElement(By.cssSelector("input[value='submit']")).click();

//        Verify the upload message.
        String uploadMessage = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("Flower.bmp",uploadMessage);

    }

}
