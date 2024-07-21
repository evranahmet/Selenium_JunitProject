package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class P04_TowerHeight extends TestBase {
    /*
       Find the height of the earliest built tower on this page:
       (Listedeki ilk inşa edilmiş kulenin uzunluğunu yazdırınız)
       https://www.techlistic.com/p/demo-selenium-practice.html
       Your code must be dynamic
       Run test with XML file
   */
    @Test
    public void towerHeight() {

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Yapılış yıllarını bir list içine alalım:
        List<WebElement> years = driver.findElements(By.xpath("(//tbody)[2]//td[4]"));

        //Minimum yılı hesplayalım:
        int minYear = Integer.parseInt(years.getFirst().getText());

        for (WebElement w : years) {

            if (Integer.parseInt(w.getText()) < minYear) {
                minYear = Integer.parseInt(w.getText());
            }

        }

        System.out.println("minYear = " + minYear);

        int idx = 0;

        for (WebElement w : years) {

            if (Integer.parseInt(w.getText()) == minYear) {
                break;
            }

            idx++;
        }

        System.out.println("idx = " + idx);

        //En düşük yılın indeksindeki yüksekliği alalım:
        String heightOfFirstBuiltTower = driver.findElements(By.xpath("(//tbody)[2]//td[3]")).get(idx).getText();
        System.out.println("heightOfFirstBuiltTower = " + heightOfFirstBuiltTower);

        assertEquals("509m", heightOfFirstBuiltTower);


    }

}
