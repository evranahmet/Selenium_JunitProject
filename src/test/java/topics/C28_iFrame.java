package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C28_iFrame extends TestBase {
/*
    iFrame, bir HTML belgesinin içine gömülü bir HTML belgesidir.
    <iframe></iframe>
    iFrame, HTML'de bir etiketle tanımlanır.

    iFrame’ler arasında geçiş yapmamız gerektiğini anlamalıyız. iFrame’ler arasında geçiş yapmak için driver’ın switchTo().frame() komutunu kullanmalıyız.
    switchTo().frame() 'i üç şekilde kullanabiliriz.
    switchTo.frame (int frame Number)
    switchTo.frame (string frame Name Or Id)
    switchTo.frame (WebElement frame Element)

    switchTo.frame (int frame Number): iFrame index’ini yazıp driver’ın o iframe geçmesini sağlanabilir. iFrame index 0’dan başlar.
    driver.switchTo().frame(0);  0. indexteki iframe'e geçmek için  First frame
    driver.switchTo().frame(1);  1. indexteki iframe'e geçmek için   Second frame

    switchTo.frame (string frame Name Or Id): switchTo komutuna Name veya ID iletilip driver’ın o iframe geçmesini sağlanabilir.

    switchTo.frame (WebElement frame Element): WebElement kullanarak geçiş yapmak en esnek seçenektir. Tercih edilen locator ile WebElement kullanarak frame bulanabilir ve ona geçiş yapılabilir.

    driver.switchTo( ).parentFrame( ); 1 üst seviyedeki frame çıkartır.
    driver.switchTo( ).defaultContent( ); En üstteki frame çıkmak için kullanılır.
*/


/*
    Go to URL: https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “Hi everyone”
    Verify the text Elemental Selenium text is displayed on the page.
 */

    @Test
    public void iFrameTest(){
//Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

//Verify the Bolded text contains “Editor”
        assert driver.findElement(By.tagName("h3")).getText().contains("Editor");

//Locate the text box
        //text box iFrame yani başka bir sayfada olduğından o iFrame'e switch yapalım:
        driver.switchTo().frame(0);//Sayfadaki ilk iFrame'e driver'ı switch ettik(götürüdük).

        WebElement textBox = driver.findElement(By.id("tinymce"));//text box iFrame yani başka bir sayfadadır.

//Delete the text in the text box
        textBox.clear();

//Type “Hi everyone”
        textBox.sendKeys("Hi everyone");

//Verify the text "Elemental Selenium" text is displayed on the page.
        //driver inner frame(iç frame'de) olduğu için parant (üst) frame'e geçmeliyiz. Çünkü elemanımız parent frame'de yer almaktadır.
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        assert driver.findElement(By.linkText("Elemental Selenium")).isDisplayed();

    }
}
