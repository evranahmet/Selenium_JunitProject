package topics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class C15___CssSelector {
//    http://the-internet.herokuapp.com/add_remove_elements/
//    Write a function that takes a number Clicks on the "Add Element" button.
//    Write a function that takes a number, and clicks the "Delete" button.
//    Then validates that given number of buttons were deleted.
//1. Method: createButtons(100)
//2. Method: DeleteButtonsAndValidate()



    @Test
    public void cssSelectorTest() {

        int addNumber = 100;
        int deleteNumber = 80;

        addElementMethod(addNumber);
        deleteElementMethod(deleteNumber);

//    Then validates that given number of buttons were deleted.
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button.added-manually"));
        System.out.println("deleteButtons.size() = " + deleteButtons.size());

        assertEquals(addNumber-deleteNumber, deleteButtons.size());


    }

    //    Write a function that takes a number Clicks on the "Add Element" button.
    private void addElementMethod(int number) {

        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));//cssSelector

        for (int i = 0; i < number; i++) {
            addButton.click();
        }

    }

    //    Write a function that takes a number, and clicks the "Delete" button.
    private void deleteElementMethod(int number) {

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button.added-manually"));
        for (int i = 0; i < number; i++) {
            deleteButtons.get(i).click();
        }
    }
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
