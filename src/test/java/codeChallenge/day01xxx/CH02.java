package codeChallenge.day01xxx;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CH02 {

    /*
    driver.navigate() Methodlari
    -  driver.navigate( ).to(String Url);  String olarak girilen Url’e gider
    -  driver.navigate( ).back ();     Icinde olunan sayfadan, geldigi onceki sayfaya dondurur
    -  driver.navigate( ).forward ();   Back ile donulen bir sayfadan tekrar ileri gider
    -  driver.navigate( ).refresh ();    Icinde olunan sayfayi yeniler.
    */

    /*
    //1-Navigate to page: https://www.ikea.com/
    //    And verify title: contains Welcome
    //2-Navigate to page:https://www.ikea.com/global/en/newsroom/
    //    And verify title: contains "Newsroom"
    //3-Navigate back:https://www.ikea.com/
    //    verify title:contains Welcome
    //4-Navigate forward:https://www.ikea.com/global/en/newsroom/
    //    verify title: contains "Newsroom"
    //5-Refresh page:
    //    verify title: contains "Newsroom"
   */


    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {

        //1-Navigate to page: https://www.ikea.com/
        driver.navigate().to("https://www.ikea.com/");
        Thread.sleep(3000);

        //    And verify title: contains Welcome
        String expectedTitel = "Welcome";
        String actualTitel = driver.getTitle();
        Assert.assertTrue(actualTitel.contains(expectedTitel));

        //2-Navigate to page:https://www.ikea.com/global/en/newsroom/
        driver.navigate().to("https://www.ikea.com/global/en/newsroom/");
        Thread.sleep(3000);

        //    And verify title: contains "Newsroom"
        Assert.assertTrue(driver.getTitle().contains("Newsroom"));
        Thread.sleep(3000);

        //3-Navigate back:https://www.ikea.com/
        driver.navigate().back();
        Thread.sleep(3000);

        //    verify title:contains Welcome
        /*String expectedTitel1 = "Welcome";
        String actualTitel1 = driver.getTitle();
        Assert.assertTrue(actualTitel1.contains(expectedTitel1));*/

        Assert.assertTrue(driver.getTitle().contains("Welcome"));


        //4-Navigate forward:https://www.ikea.com/global/en/newsroom/
        driver.navigate().forward();
        Thread.sleep(3000);

        //    verify title: contains "Newsroom"
        Assert.assertTrue(driver.getTitle().contains("Newsroom"));

        //5-Refresh page:
        driver.navigate().refresh();
        Thread.sleep(3000);

        //    verify title: contains "Newsroom"
        Assert.assertTrue(driver.getTitle().contains("Newsroom"));

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();

    }
}
