package topics;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C27_BasicAuthentication extends TestBase {
    /*
        BasicAuthentication : Normal olarak web sitelerinde login fonksiyonu icin kullanici adi ve sifre
        webelementlerine bilgileri girip, login buttonuna basariz.
        Ancak bazi websitelerinde ve ozellikle API haberlesmesinde kullanici adi ve sifreyi manuel olarak tek
        tek girmek yerine, servis saglayicinin bize vereccegi bilgiler dogrultusunda, kulllanici adi ve sifreyi
        URL’e ekleyebiliriz.
        Boylece sayfaya gitme ve login fonksiyonu tek adimda halledilmis olur.

        Auth güvenlik nedeniyle kullanılır
        Yetkilendirmenin bir yolu, aşağıdaki sözdizimini kullanmaktır:
        https://kullanıcı adı:şifre@URL
    */
/*
    Go to URL: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
    Authenticate using the above method and test data.
    https://admin:admin@the-internet.herokuapp.com/basic_auth
    Verify the congratulations message.
*/
    @Test
    public void BasicAuthTest() {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        assert !driver.findElement(By.tagName("p")).getText().contains("Congratulations") : "Message does not contain 'Congratulations'";

    }


}
