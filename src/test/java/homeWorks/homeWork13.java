package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class homeWork13 extends TestBase {

/*
	Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
	Shift 34 units to the up and 34 units to the down on the vertical axis.
*/
@Test
public void slider(){
    driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");
    WebElement slider = driver.findElement(By.xpath("(//span[@class='range-slider-handle'])[1]"));
    System.out.println("V1= " + slider.getAttribute("aria-valuenow"));
    Actions actions=new Actions(driver);
    actions.dragAndDropBy(slider,0,-34).perform();
    System.out.println("V2 = " + slider.getAttribute("aria-valuenow"));
    actions.dragAndDropBy(slider,0,34).perform();
    System.out.println("V3 = " + slider.getAttribute("aria-valuenow"));
}
}
