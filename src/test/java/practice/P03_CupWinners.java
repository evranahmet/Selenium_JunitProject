package practice;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class P03_CupWinners {
    //Place the winners of the World Cup and the European Cup in two separate maps with their years.
    @Test
    public void cupWinnersTest() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("resources/CupWinners.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet worldCup = workbook.getSheet("WorldCup");
        Map<String, String> worldCupMap = new TreeMap<>();

        for (int i = 1; i <= worldCup.getLastRowNum(); i++) {
            String year = worldCup.getRow(i).getCell(0).toString().substring(0, 4);
            String country = worldCup.getRow(i).getCell(1).toString();

            worldCupMap.put(year, country);

        }

        System.out.println(worldCupMap);

        System.out.println("=====================");

        Sheet europeanCup = workbook.getSheet("EuropeanCup");
        Map<String, String> europeanCupMap = new TreeMap<>();

        for (int i = 1; i <= europeanCup.getLastRowNum(); i++) {
            String year = europeanCup.getRow(i).getCell(0).toString().substring(0, 4);
            String country = europeanCup.getRow(i).getCell(1).toString();

            europeanCupMap.put(year, country);

        }

        System.out.println(europeanCupMap);

    }
}
