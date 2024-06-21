package topics;

import org.junit.Test;
import utilities.TestBase;

public class C17_TestBase extends TestBase {//TestBase classına extend yaparak driver'a ulaşabiliriz.

    @Test
    public void test1(){
        driver.get("http://google.com");

    }
    @Test
    public void test2() {

        driver.get("https://linkedin.com");

    }
    @Test
    public void test3() {

        driver.get("https://clarusway.com");

    }
}
