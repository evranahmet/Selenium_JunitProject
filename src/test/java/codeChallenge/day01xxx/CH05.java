package codeChallenge.day01xxx;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CH05 {

    /*
        go to https://eviltester.github.io/simpletodolist/todolists.html
        then
        verify display eviltester on todo_list
        and
        delete eviltester
        Then
        Enter new todo_list as "Clarusway"
        And
        Verify new todo_list is created
        Then
        add new Todo_ as "merhaba admin" on the new todo_list
        And
        Verify new Todo_ is added
        Then
        Login as Admin
        And
        Verify
         {"active":1,"completed":0,"total":1}
         Then
        Delete the new Todo_ and the new todo_list
        And
        Verify is deleted

        */

    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {

        //go to https://eviltester.github.io/simpletodolist/todolists.html
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");

        //        verify display eviltester on todo_list
        WebElement testerText = driver.findElement(By.xpath("//label"));
        Assert.assertTrue(testerText.isDisplayed());

        //        delete eviltester
        driver.findElement(By.xpath("//button[@class='destroy']")).click();
        driver.switchTo().alert().accept();

        //        Enter new todo_list as "Clarusway"
        driver.findElement(By.xpath("//input[@class='new-todo-list']")).sendKeys("Clarusway" + Keys.ENTER);

        //        Verify new todo_list is created
        WebElement clarusText = driver.findElement(By.xpath("//label"));
        Assert.assertTrue(clarusText.isDisplayed());

        //        add new Todo_ as "merhaba admin" on the new todo_list

        driver.findElement(By.xpath("//a[.='[use]']")).click();
        driver.findElement(By.xpath("//input[@class='new-todo']")).sendKeys("merhaba admin" + Keys.ENTER);

        //        Verify new Todo_ is added
        String actual = driver.findElement(By.xpath("(//label)[2]")).getText();
        Assert.assertEquals("merhaba admin", actual);

        //        Login as Admin
        driver.findElement(By.id("navadminlogin")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AdminPass");
        driver.findElement(By.id("login")).click();


        //        Verify {"active":1,"completed":0,"total":1}
        String text = driver.findElement(By.xpath("//ul[@class='todo-list-list']")).getText();
        Assert.assertTrue(text.contains("{\"active\":1,\"completed\":0,\"total\":1}"));

        //        Delete the new Todo_ and the new todo_list

        driver.findElement(By.id("Clarusway")).click();
        driver.findElement(By.id("toggle-all")).click();
        driver.findElement(By.xpath("//button[@class=\"clear-completed\"]")).click();

        //        Verify is deleted
        Assert.assertFalse(driver.findElement(By.id("toggle-all")).isDisplayed());

    }


    @AfterClass
    public static void tearDown() {
        //driver.close();

    }
}
