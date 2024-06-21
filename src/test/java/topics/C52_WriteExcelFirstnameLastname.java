package topics;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C52_WriteExcelFirstnameLastname {

    //Create Firstname and Lastname Columns and write names in a new sheet

    @Test
    public void excelTest() throws IOException {

        String filePath = System.getProperty("user.dir") + "\\resources\\Capitals.xlsx";
        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));

        //Create a new sheet
        Sheet newSheet = workbook.createSheet("FirstnameLastname");

        //Create Firstname and Lastname Columns
        newSheet.createRow(0).createCell(0).setCellValue("Firstname");
        newSheet.getRow(0).createCell(1).setCellValue("Lastname");//2. kez create yaparsak bir önceki silinir.

       //Fill some rows
        Row row2 = newSheet.createRow(1);
        row2.createCell(0).setCellValue("John");
        row2.createCell(1).setCellValue("Doe");

        for (int i = 2; i< 500; i++){

            newSheet.createRow(i).createCell(0).setCellValue(Faker.instance().name().firstName());
            newSheet.getRow(i).createCell(1).setCellValue(Faker.instance().name().lastName());//2. kez create yaparsak bir önceki silinir.

        }


        workbook.write(new FileOutputStream(filePath));

    }


}
