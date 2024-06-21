package topics;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.JavascriptUtils;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static utilities.JavascriptUtils.clickElementByJS;

public class C62_LocalPageTest extends TestBase {
/*
    Go to C:\Users\Clarusway\IdeaProjects\CH5_JunitProject\resources\TestPage.html
    Fill all fields
    Click register
    Verify the alert text is 'Form submitted!'
*/

    @Test
    public void localPageTest() {
//        Go to C:\Users\Clarusway\IdeaProjects\CH5_JunitProject\resources\TestPage.html
        driver.get(System.getProperty("user.dir") + "\\resources\\TestPage.html");

//        Fill all fields
        driver.findElement(By.id("ssn")).sendKeys("334-66-7890");
        driver.findElement(By.id("firstName")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastName")).sendKeys(Faker.instance().name().lastName());
        clickElementByJS(driver.findElement(By.id("male")));

        new Select(driver.findElement(By.id("job"))).selectByVisibleText("Tester");
        driver.findElement(By.id("cv")).sendKeys(System.getProperty("user.dir") + "/resources/CV.pdf");

        driver.findElement(By.id("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());
        driver.findElement(By.id("password")).sendKeys("Johndoe.123");

//        Click register
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        Verify the alert text is 'Form submitted!'
        String alertText = driver.switchTo().alert().getText();
        assertEquals("Form submitted!", alertText);

    }

}
