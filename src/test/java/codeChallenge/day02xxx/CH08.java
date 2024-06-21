package codeChallenge.day02xxx;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.*;

public class CH08 extends TestBase {
    /*
    go to https://sweetshop.vivrichards.co.uk/
    click "Browse Sweets" button
    Then
    Click Add to Basket Button for "Sherbert Straws","Bon Bons" and "Bubble Gums"
    And
    Go to Basket
    Then
    Verify Your Basket inculuding are "Sherbert Straws","Bon Bons" and "Bubble Gums"
    And
    Delete "Bubble Gums" for Basket
    Then
    You use faker class and enter your payment and delivery details.
    And
    Click "Continue to checkout"Button
     */

    List<String> expectedBasketList = new ArrayList<>();

    public void addToCart(String input) {

        driver.findElement(By.xpath("//a[@data-name='" + input + "']")).click();
        expectedBasketList.add(input);
    }

    @Test
    public void test01() {

        //go to https://sweetshop.vivrichards.co.uk/
        driver.get("https://sweetshop.vivrichards.co.uk/");

        //    click "Browse Sweets" button
        driver.findElement(By.xpath("//a[.=\"Browse Sweets\"]")).click();


        //    Click Add to Basket Button for "Sherbert Straws","Bon Bons" and "Bubble Gums"
        addToCart("Sherbert Straws");
        addToCart("Strawberry Bon Bons");
        addToCart("Bubble Gums");

        //    Go to Basket
        driver.findElement(By.xpath("//a[@href='/basket']")).click();
        //driver.navigate().to("https://sweetshop.vivrichards.co.uk/sweets");


        //    Verify Your Basket inculuding are "Sherbert Straws","Bon Bons" and "Bubble Gums"

        List<WebElement> basketList = driver.findElements(By.xpath("//h6[@class=\"my-0\"]"));

        List<String> actualBasketList = new ArrayList<>();

        for (WebElement a : basketList) {
            //System.out.println(a.getText());
            actualBasketList.add(a.getText());
        }

        Collections.sort(actualBasketList);
        Collections.sort(expectedBasketList);

        Assert.assertEquals(expectedBasketList, actualBasketList);

        //    Delete "Bubble Gums" for Basket
        driver.findElement(By.xpath("//h6[.=\"Bubble Gums\"]/following-sibling::a")).click();
        driver.switchTo().alert().accept();

        //    You use faker class and enter your payment and delivery details.


        //    Click "Continue to checkout"Button


    }


}
