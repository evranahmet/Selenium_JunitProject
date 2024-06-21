package topics;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C31_WindowHandle3 extends TestBase {
/*
    Open https://www.google.com/
    Create a new tab
    Open https://www.linkedin.com/ in the opened tab
    Switch to first tab get go to https://clarusway.com/ without getting its windowhandle
*/

    @Test
    public void windowHandleTest(){
//Open https://www.google.com/
        driver.get("https://www.google.com");

//Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);

//Open https://www.linkedin.com/ in the opened tab
        driver.get("https://www.linkedin.com");

//Switch to first tab get go to https://clarusway.com/ without getting its windowhandle
        Set<String> windowHandlesSet = driver.getWindowHandles();//getWindowHandles methodu Set döneceğinden index içermediği için belirli bir elementi direkt alamyız.
        List<String> windowHandleslist = new ArrayList<>(windowHandlesSet);//Set'i list' çevirerek index ile isteğimiz elemente ulaşabiliriz.
        String window1 = windowHandleslist.get(0);
        String window2 = windowHandleslist.get(1);

        driver.switchTo().window(window1).get("https://clarusway.com");

    }
}
