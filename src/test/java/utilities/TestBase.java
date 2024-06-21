package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {//Classı abstract yaparak bu classtan obje oluşturulmasını engelliyoruz.
/*
    TestBase Class: Her test class'ında tekrar tekrar yazdığımız setup ve teardown method'larını tekrar
    yazmaktan kurtulmak için Java OOP konseptini kullanarak oluşturduğumuz bir class'tır.

    - Test Base'i parent olarak kabul eden class'lar hazırlık için oluşturduğumuz driver, setup() ve teardown()
    metodlarını oluşturmak zorunda kalmazlar; kendilerinde olmasa bile parent class'tan kullanılabilir.

    - TestBase genellikle testlerden farklı bir pakette bulunduğundan driver'ı kullanabilmek için public veya
    protected yapmamız gerekir. Biz hep child class'lardan kullanacağımız için protected yapmayı tercih ettik.

    - Bu class sadece child class'lardan inheritance özellikleri ile kullanılsın istediğimizden, bu class'ın
    obje oluşturularak kullanılmasına engel olmak için class'ı abstract YAPABİLİRİZ.

    - Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz. TestBase Class'ını sadece
    extends ile inherit ederek kullanacağız. Dolayısıyla oluşturduğumuz driver variable'ı için protected access
    modifier'ı seçiyoruz.
*/

    protected static WebDriver driver;//protected access modifier ile driver objesine class pacgae dışından sadece subclasslar ulaşabilir.
    protected static ExtentReports extentReports; // Raporlama işlemini gerçekleştirir
    protected static ExtentSparkReporter extentHtmlReporter; // Raporu HTML olarak düzenler
    protected static ExtentTest extentTest; // Testimizin pass veya fail olduğunu saklayan objemiz. Ekran görüntüleri için de kullanılır

    @Before//Her @Test methodu öncesi çalışır.
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//Web elementin yüklenip bulunması için 15 saniyeye kadar bekler. NoSuchElementException atar.
    }

    @After//Her @Test methodu sonrası çalışır.
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void getFullPageScreenShot() {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File ss = screenshot.getScreenshotAs(OutputType.FILE);

        String time = new SimpleDateFormat("yyMMddhhmmss").format(new Date()) + System.nanoTime();

        try {
            FileUtils.copyFile(ss, new File("test-output/screenshots/" + time + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void getSpecificElementsScreenShot(WebElement element) {

        File ss = element.getScreenshotAs(OutputType.FILE);

        String time = new SimpleDateFormat("yyMMddhhmmss").format(new Date()) + System.nanoTime();

        try {
            FileUtils.copyFile(ss, new File("test-output/screenshots/" + time + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public String getCellValue(String excelName, String sheetName, int rowIndex, int cellIndex) {

        String filePath = System.getProperty("user.dir") + "\\resources\\" + excelName + ".xlsx";
        FileInputStream fileInputStream = null;
        Workbook workbook;
        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).toString();
    }

    //Bu method web element olarak girilen web table'ın belirtilen satırının belirtilen sütunun String olarak döner.
    public String getTableCell(WebElement element, int row, int column) {

        return element.findElement(By.xpath(".//tr["+row+"]/td["+column+"]")).getText();

    }

    public ExtentReports extentReportsSetUp() {

        // Extent report objelerimizi oluşturuyoruz
        extentReports = new ExtentReports();

        // Kaydedeceğimiz dosya için tarih stringi oluşturuldu
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "\\test-output\\reports\\testReport_" + currentDate;

        // HTML raporu oluşturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentSparkReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter bağlandı
        extentReports.attachReporter(extentHtmlReporter);

        // Test başlatılıyor
        //extentTest = extentReports.createTest(TestBase.class.getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());

        // Rapor ile alakalı ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Tester CW");
        extentReports.setSystemInfo("Company", "Clarusway");

        // HTML raporunda görüntülemek istediğimiz konfigürasyonlar yapıldı
        extentHtmlReporter.config().setDocumentTitle("JUnit_Report");
        extentHtmlReporter.config().setReportName("Test run report");

       // extentReports.flush(); //--> Test sonu raporun oluştutulması için unutulmamalıdır.

        return extentReports;

    }
    //Bu method arguman olarak girilen By objesinin görünür olmasını 10 saniye bekler ve locate ederek o elementi döner.
    // Bulamaz ve zaman dolarsa TimeOutException atar.
    public static WebElement waitAndLocate(By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }

}