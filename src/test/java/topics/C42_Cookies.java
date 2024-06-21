package topics;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C42_Cookies extends TestBase {
    /*
        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        Get Cookie.
        Find the total number of cookies.
        Print all the cookies.
        Add Cookie.
        Edit Cookie.
        Delete Cookie.
        Delete All Cookies.
     */
    @Test
    public void cookiesTest() {

//        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

//        Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);//Lambda tercih edilir

//        Get Cookie.
        Cookie cookie = driver.manage().getCookieNamed("vegetable");
        System.out.println("vegetable cookie = " + cookie);

//        Find the total number of cookies.
        System.out.println("Total number of cookies: " + cookies.size());

//        Add Cookie.
        Cookie karbonhidrat = new Cookie("Karbonhidrat", "Makarna");
        driver.manage().addCookie(karbonhidrat);
        System.out.println("Total number of cookies after add: " + driver.manage().getCookies().size());

//        Delete Cookie.
        driver.manage().deleteCookie(karbonhidrat);
        driver.manage().deleteCookieNamed("protein");
        System.out.println("Total number of cookies after delete: " + driver.manage().getCookies().size());

//        Delete All Cookies.
        driver.manage().deleteAllCookies();
        System.out.println("Total number of cookies after delete all: " + driver.manage().getCookies().size());
    }
}
