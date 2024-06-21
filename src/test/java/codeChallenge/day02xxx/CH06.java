package codeChallenge.day02xxx;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Random;

public class CH06 extends TestBase {

    /*
    **** React Uygulama, değişken XPath
    Given
     Go to https://react-shopping-cart-67954.firebaseapp.com
    When
     Click random 3 Add To Cart Button
    Then
     Verify that there are 3 items in the cart
    And
     Click Checkout Button
    Then
     Verify Subtotal

     * https://www.guru99.com/using-contains-sbiling-ancestor-to-find-element-in-selenium.html
    */

    @Test
    public void test1() {

        //     Go to https://react-shopping-cart-67954.firebaseapp.com/
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        //     Click random 3 Add To Cart Button
        List<WebElement> adToCartList = driver.findElements(By.xpath("//button[@tabindex=\"-1\"]"));

        for (int i = 0; i < 3; i++) {

            Random rdm = new Random();
            int sayi = rdm.nextInt(16);

            adToCartList.get(sayi).click();
        }

        //     Verify that there are 3 items in the cart
        String actual = driver.findElement(By.xpath("//span[.='Cart']/parent::div/div/div")).getText();

        Assert.assertEquals("3", actual);

        //     Click Checkout Button
        String expectedTotal = driver.findElement(By.xpath("//p[.='SUBTOTAL']/following-sibling::div/p")).getText();

        driver.findElement(By.xpath("//*[.='Checkout']")).click();


        //     Verify Subtotal
        String actualTotal = driver.switchTo().alert().getText();
        Assert.assertTrue(actualTotal.contains(expectedTotal));

        driver.switchTo().alert().accept();
    }


}
