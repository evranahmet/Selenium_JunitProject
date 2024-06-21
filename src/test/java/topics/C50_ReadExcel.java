package topics;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class C50_ReadExcel {
//Workbook → Excel dosyası.
//Sheet → Excel çalışma sayfası (Sheet1, Sheet2, vb.).
//Row (Satır) → Java, yalnızca içinde veri bulunan satırları sayar.
//Cell (Hücre) → Java her satıra bakar ve yalnızca hücrede veri bulunuyorsa hücre sayısını sayar.

//Workbook (excel)> Worksheet (sheet)> Row (satır)> Cell (hücre) -> hiyerarşi

    /*
        Add the excel file on the resources folder.
        Open the file.
        Open the workbook using file input stream.
        Open the first worksheet.
        Go to first row.
        Go to first cell on that first row and print.
        Go to second cell on that first row and print.
        Go to 2nd row first cell and assert if the data equal to the USA.
        Go to 3rd row and print 2nd cell
        Find the number of used row.
        Print country, capital value pairs as map object.
        Verify that you have Canada on the list
    */
    @Test
    public void readExcelTest() throws IOException {

//Add the excel file on the resources folder.
//Open the file.
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\resources\\Capitals.xlsx");

//Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//Open the first worksheet.
        Sheet sheet1 = workbook.getSheet("Sheet1");

//Go to first row.
        Row row1 = sheet1.getRow(0);

//Go to first cell on that first row and print.
        Cell r1c1 = row1.getCell(0);
        System.out.println("r1c1 = " + r1c1);

//Go to second cell on that first row and print.
        Cell r1c2 = row1.getCell(1);
        System.out.println("r1c2 = " + r1c2);

//Go to 2nd row first cell and assert if the data equal to the USA.
        Cell r2c1 = sheet1.getRow(1).getCell(0);
        System.out.println("r2c1 = " + r2c1);
        assertEquals("USA", r2c1.toString());

//Go to 3rd row and print 2nd cell
        Cell r3c2 = sheet1.getRow(2).getCell(1);
        System.out.println("r3c2 = " + r3c2);

//Find the number of used row.
        int lastRowIndex = sheet1.getLastRowNum();//som kullanılmış olan satır
        System.out.println("lastRowIndex = " + lastRowIndex);

        int physicalNumberOfRows = sheet1.getPhysicalNumberOfRows();//Fiziki olarak kullanılmış satır sayısı.
        System.out.println("physicalNumberOfRows = " + physicalNumberOfRows);

//Print country, capital value pairs as map object.
        Map<String, String> country_capital = new HashMap<>();

        for (int i = 1; i <= lastRowIndex; i++) {

            String country = sheet1.getRow(i).getCell(0).toString();
            String capital = sheet1.getRow(i).getCell(1).toString();

            country_capital.put(country, capital);
        }

        System.out.println("country_capital = " + country_capital);


//Verify that you have Canada on the list
        assert country_capital.containsKey("Canada");


    }
}
