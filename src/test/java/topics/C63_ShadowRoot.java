package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C63_ShadowRoot extends TestBase {

    @Test
    public void shadowRootTest(){

        driver.get("https://practice.expandtesting.com/shadowdom#google_vignette");

        //Locate shadow root --> 1) Önce elementin içinde bulunduğu shadow root locate edilir.
        WebElement shadowHost= driver.findElement(By.id("shadow-host"));

        // Use JavaScript to get the shadow root and then the web element inside it
        JavascriptExecutor js= (JavascriptExecutor) driver;

        //2) Shadow root içinde yer alan web element js executor içinde css selector ile locate edilir.
        WebElement button = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('#my-btn')", shadowHost);

        //Get button's text
        System.out.println(button.getText());
        // Click the button
        button.click();

    }

}
