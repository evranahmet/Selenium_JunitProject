package codeChallenge.day01xxx;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CH01 {

    /*
       driver.get() Methodlari
        -  driver.get(String Url);     String olarak girilen Url’e gider
        -  driver.getTitle();          Icinde olunan sayfanin basligini String olarak getirir
        -  driver.getCurrentUrl();     Icinde olunan sayfanin Url’ini String olarak getirir
        -  driver.getPageSource();     Icinde olunan sayfanin kaynak kodlarini String olarak getirir
    /*

     /*
    //1) Open the browser
    //2) Enter the URL https://www.ikea.com/
    //3) set expected title "Welcome"
    //4) using getTitle() to retrieve actual title.
    //5) verify title: contains "Welcome"
    //6) get currentUrl text
   */

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        //1) Open the browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {

        Thread.sleep(5000);
        //2) Enter the URL https://www.ikea.com/
        driver.get("https://www.ikea.com/");

        //3) set expected title "Welcome"
        String expectedTitle = "Welcome";
        System.out.println("expectedTitle = " + expectedTitle);

        //4) using getTitle() to retrieve actual title.
        String actualTitle = driver.getTitle();

        //5) verify title: contains "Welcome"
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //6) get currentUrl text
        System.out.println("getCurrentUrl -> "+driver.getCurrentUrl());

    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
