package codeChallenge.day03;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CH15 extends TestBase {


    /*
    - https://www.kitapyurdu.com/ sitesi acilir.
    - Ana sayfanin acildigi kontrol edilir.
    - Urun arama alanina "roman" yazdirilir ve klavyeden "enter" tusuna basilir.(Urun aramak icin
    yazilacak roman kelimesi cvs uzantili dosyadan okunmasi gerekmektedir.)

    cizgi roman
     */

    /*
     <!-- https://mvnrepository.com/artifact/com.opencsv/opencsv -->
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.6</version>
        </dependency>
     */

    @Test
    public void test() {

        // - https://www.kitapyurdu.com/ sitesi acilir.
        driver.get("https://www.kitapyurdu.com/");

        //  - Ana sayfanin acildigi kontrol edilir.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.kitapyurdu.com/";

        Assert.assertEquals(expectedUrl, actualUrl);

        //  - Urun arama alanina "roman" yazdirilir ve klavyeden "enter" tusuna basilir.
        driver.findElement(By.id("search-input")).sendKeys("roman" + Keys.ENTER);

    }

    @Test
    public void csvTest() throws IOException, CsvException {

        // - https://www.kitapyurdu.com/ sitesi acilir.
        driver.get("https://www.kitapyurdu.com/");

        // - Ana sayfanin acildigi kontrol edilir.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.kitapyurdu.com/";

        Assert.assertEquals(expectedUrl, actualUrl);

        // - Urun arama alanina "roman" yazdirilir ve klavyeden "enter" tusuna basilir.(Urun aramak icin

        List<String> dataList = csvReader("data.cvs");
        driver.findElement(By.id("search-input")).sendKeys(dataList.get(0) + Keys.ENTER);


    }

    public List<String> csvReader(String path) throws IOException, CsvException {

        CSVReader reader = new CSVReader(new FileReader(path));
        String[] csvCell;
        List<String> values = new ArrayList<>();
        boolean firstLine = true;

        while ((csvCell = reader.readNext()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String value = csvCell[0];
            values.add(value);
        }

        return values;
    }


}
