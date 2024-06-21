package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C53_WebTables01 extends TestBase {
/*
    <table>, bir web tablosunu tanımlamak için kullanılan HTML etiketidir.
    Tablonun başlığını tanımlamak için <th> kullanılırken,
    web tablosu için sırasıyla satırları ve sütunları tanımlamak için <tr> ve <td> etiketleri kullanılır.

    table//tbody//tr ➡ tbody içindeki tüm satırları döndürür.
    table//tbody//tr[1] ➡ tbody'deki ilk satırı döndürür.
    table//tbody//tr[1]//td ➡ İlk satırdaki tüm tablo hücrelerini döndürür.
    table//tbody//tr[1]//td[4] ➡ tbody'deki ilk satırdaki 4. hücreyi döndürür.
    table//tbody//tr[4]//td[5] ➡ 4. satır 5. sütun
    table//tbody//tr[10]//td[2] ➡ Satır 10'daki 2. sütun
    table//tbody//tr//td[5] ➡ 5. sütundaki tüm satırları döndürür.
*/

        /*
            Go to URL: http://demo.guru99.com/test/web-table-element.php
            To find third row of table
            To get 3rd row's 3rd column data
            Get all the values of a Dynamic Table
        */
        @Test
        public void webTableTest() {

            //Go to URL: http://demo.guru99.com/test/web-table-element.php
            driver.get("http://demo.guru99.com/test/web-table-element.php");

//To find third row of table
            String r3 = driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();
            System.out.println("r3 = " + r3);

//To get 3rd row's 3rd column data
            String r3c3 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText();
            System.out.println("r3c3 = " + r3c3);

//Get all the values of a Dynamic Table
            //Kodun daha dinamik olabilmesi için. Locate edilen web table içinde satırları alalım.
            WebElement webTable = driver.findElement(By.xpath("//table[@class='dataTable']"));

            List<WebElement> rowList = webTable.findElements(By.xpath(".//tr"));// Başa nokta eklenerek sadece locate edilen web element içinde arama yapılır.

            for (int i = 0; i<rowList.size(); i++){

                System.out.println(rowList.get(i).getText());

            }

        }
    }

