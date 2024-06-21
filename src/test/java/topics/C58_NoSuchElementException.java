package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C58_NoSuchElementException extends TestBase {

    @Test
    public void test1(){

        driver.get("https://google.com");

        driver.findElement(By.id("olmayanId")).click();//NoSuchElementException

    }

    @Test
    public void test2(){

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Webelementi iFrame içinde bulunduğu için bu frame'e geçmeden locate yaparsak NoSuchElementException alırız.
        System.out.println(driver.findElement(By.id("draggable")).getText());//NoSuchElementException

    }

    @Test
    public void test3(){

        driver.get("https://testpages.eviltester.com/styled/windows-test.html");

        //Click on Basic Ajax in new page
        driver.findElement(By.id("gobasicajax")).click();

        //Tüm window handle değerlerini alıp 2. window handle'a geçiniz...

        //Submit butonu yeni açılan pencerede olduğu için driver bu pencereye geçmeden locate yaparsak NoSuchElementException alırız.
        driver.findElement(By.name("submitbutton")).click();//NoSuchElementException

    }

}
