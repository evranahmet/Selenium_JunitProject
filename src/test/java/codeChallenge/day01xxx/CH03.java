package codeChallenge.day01xxx;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CH03 {

    /*
    TESTLİO (https://testlio.com/) LİVE INTERVİEW QUESTION
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Test whether the Home page has Three Sliders only
    //4) The Home page must contains only three sliders
    */

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        //1) Open the browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Test whether the Home page has Three Sliders only

        List<WebElement> sliderList = driver.findElements(By.xpath("//div[@data-slide-duration='0']"));

        Assert.assertEquals(3, sliderList.size());

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();

    }
}
