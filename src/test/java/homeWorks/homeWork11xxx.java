package homeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class homeWork11xxx extends TestBase {

    /*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.(Üzerlerini çiziniz)
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
*/
    @Test
    public void toDoList() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        String[] toDoList = {"Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"};
        for (String toDoListItem : toDoList) {
            WebElement newToDo = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
            newToDo.sendKeys(toDoListItem);
            newToDo.sendKeys(Keys.ENTER);
        }
        List<WebElement> strikeThrough = driver.findElements(By.cssSelector("li"));
        for (WebElement ciz : strikeThrough) {
            ciz.click();
        }
        List<WebElement> deleteAll = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for (WebElement sil : deleteAll) {
            sil.click();
        }
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.cssSelector("li")).isEmpty());

    }
    //2. yol Rooney Hoca
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        setTodos("Prepare breakfast");
        setTodos("Wash the dishes");
        setTodos("Take care of baby");
        setTodos("Help your kid's homework");
        setTodos("Study Selenium");
        setTodos("Sleep");
        List<WebElement>todoList=driver.findElements(By.tagName("li"));
        List<WebElement>trashList=driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        Actions a = new Actions(driver);
        for (int i = 0; i <todoList.size() ; i++) {
            a.moveToElement(todoList.get(i)).click().perform();
        }
        for (int i = 0; i <trashList.size() ; i++) {
            a.moveToElement(trashList.get(i)).click().perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        todoList=driver.findElements(By.tagName("li"));
        Assert.assertTrue(todoList.isEmpty());
    }
    public void setTodos(String todos){
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(todos+ Keys.ENTER);
    }
}

