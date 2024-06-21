package topics;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C30_WindowHandle2 extends TestBase {
/*
    Open browser
    Create a new tab
    Create a new window
    Open https://www.linkedin.com/ in the second tab
    Open https://clarusway.com/ in the last window
    Open https://www.youtube.com/ in the first tab
*/

    @Test
    public void windowHandleTest() {
        //Open browser
        driver.get("about:blank");
        String window1 = driver.getWindowHandle();//Window1 windowHandle değerini alıyoruz.(Sayfanın kimliği)

        //Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        String window2 = driver.getWindowHandle();//Window2 windowHandle değerini alıyoruz.(Sayfanın kimliği)

        //Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String window3 = driver.getWindowHandle();//Window1 windowHandle değerini alıyoruz.(Sayfanın kimliği)

        //Open https://www.linkedin.com/ in the second tab
        driver.switchTo().window(window2).get("https://www.linkedin.com");//driver'ı window2'ye (second tab) switch ettik.

        //Open https://clarusway.com/ in the last window
        driver.switchTo().window(window3).get("https://clarusway.com");

        //Open https://www.google.com/ in the first tab
        driver.switchTo().window(window1).get("https://google.com");

    }

}
