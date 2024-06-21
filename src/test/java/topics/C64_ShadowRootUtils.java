package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ShadowRootsUtils;
import utilities.TestBase;

public class C64_ShadowRootUtils extends TestBase {

    @Test
    public void shadowRootTest(){

        driver.get("https://practice.expandtesting.com/shadowdom#google_vignette");

        //Locate shadow root --> 1) Önce elementin içinde bulunduğu shadow root locate edilir.
        WebElement shadowHost= driver.findElement(By.id("shadow-host"));

        WebElement button = ShadowRootsUtils.shadowRootLocator(shadowHost,"#my-btn");

        //Get button's text
        System.out.println(button.getText());

        // Click the button
        button.click();

    }

}
