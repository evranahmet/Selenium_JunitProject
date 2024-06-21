package codeChallenge.day01xxx;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CH04 {

    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("10");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("5");

        // Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        // Get the result
        // Print the result
        String answer = driver.findElement(By.id("answer")).getText();

        System.out.println("answer = " + answer);

    }


    @AfterClass
    public static void tearDown() {
       // driver.close();

    }
}
