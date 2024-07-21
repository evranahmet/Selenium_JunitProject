package codeChallenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CH16 extends TestBase {

    /*
  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
  ~ click on Phones & PDAs
  ~ get the brandName of phones
  ~ lick on add to button for all elementsc
  ~ click on black total added cart button
  ~ get the names of list from the cart
  ~ compare the names from displaying list and cart list
   */

    @Test
    public void test() throws InterruptedException {

        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //  ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[.='Phones & PDAs']")).click();

        //  ~ get the brandName of phones
        getName();

        //  ~ click on add to button for all elements
        clickAllElements();

        //  ~ click on black total added cart button
        driver.findElement(By.id("cart")).click();

        //  ~ get the names of list from the cart
        getCartList();

        //  ~ compare the names from displaying list and cart list
        Assert.assertEquals(getName(), getCartList());
    }

    public List<String> getName() {

        List<WebElement> nameList = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));

        List<String> stringName = new ArrayList<>();

        for (int i = 0; i < nameList.size(); i++) {

            stringName.add(nameList.get(i).getText());
        }

        Collections.sort(stringName);
        return stringName;
    }

    public void clickAllElements() throws InterruptedException {

        List<WebElement> allList = driver.findElements(By.xpath("//*[.='Add to Cart']"));

        for (int i = 0; i < allList.size(); i++) {
            allList.get(i).click();
            Thread.sleep(2000);
        }

    }

    public List<String> getCartList() { // "//td[@class='text-left']/a" -> WebTable phoneName 2. locate alma yontemi

        List<WebElement> cartList = driver.findElements(By.xpath("//table[@class='table table-striped']//tr/td[2]/a"));

        List<String> cartStringList = new ArrayList<>();

        for (int i = 0; i < cartList.size(); i++) {
            cartStringList.add(cartList.get(i).getText());

        }

        Collections.sort(cartStringList);
        return cartStringList;
    }


}
