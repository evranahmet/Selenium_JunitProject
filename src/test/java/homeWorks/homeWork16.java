package homeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class homeWork16 extends TestBase {
    /*
Go to https://testfile.org/
Download a PDF file
Verify it is downloaded
*/
    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://testfile.org/");
        driver.findElement(By.xpath("(//ul[@id='menu-1-c99e9f4']//a[contains(text(),'PDF')])[1]")).click();
        driver.findElement(By.xpath("//a[@href='https://link.testfile.org/PDF10MB']")).click();
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
//        boolean isFlowerExist = Files.exists(Path.of("https://files.testfile.org/PDF/10MB-TESTFILE.ORG.pdf"));//kodun dinamik olabilmesi için, dosya yolunun dinamik yazılması gerekir.
//        assertTrue(isFlowerExist);

    }
}
