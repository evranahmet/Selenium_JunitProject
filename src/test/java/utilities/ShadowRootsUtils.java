package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ShadowRootsUtils extends TestBase {

    public static WebElement shadowRootLocator(WebElement shadowHost, String elementCSSSelector) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('" + elementCSSSelector + "')", shadowHost);

    }

}
