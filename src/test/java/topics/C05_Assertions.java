package topics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class C05_Assertions {

    @Test
    public void assertEqualsTest(){
        // Assert.assertEquals("Expected Result","Actual Result");   buradaki expected ile actual birbirine eşit ise test geçer, değil ise test kalır.
        // Assert.assertEquals() metodu iki tane parametre kabul eder. Parametreleri karşılaştırma yapar.
        // 1'inci parametre expected, 2'nci parametre ise actual result içindir

        String name="John";

        assertEquals("John",name);//2 parametreli kullanıldığında parantez içindeki 2 argüman karşılaştırılır.
        assertEquals("İsim tutmadı","JohnX",name);//3 parametreli kullanıldığında ilk parametredeki string argüman fail olma durumunda fail mesaj olarak yazdırılır
    }
    @Test
    public void assertTrueMethod(){

        //Assert.assertTrue(); burada () parantez içindeki değer true ise test geçer, değilse test fail olur
        // Bir testten true sonucunu bekliyorsak .assertTrue() kullanırız. Yani pozitif senoryalarda.
        // Bir testten false sonucunu bekliyorsak .assertFalse() kullanırız. Yani negatif senaryolarda.
        //2 parametreli kullanıldığı zaman birinci parametreye failure mesajı konulabilir

        assertTrue("hello".contains("e"));

        String name = "Mary";
        assertTrue(name.contains("a"));
        assertTrue("name does not contain substring",name.contains("x"));

    }
    @Test
    public void assertFalseMethod() {
        //assertFalse() metodunun parantez içindeki değeri False dönerse test geçer, true dönerse test kalır.
        //2 parametreli kullanıldığı zaman birinci parametreye failure mesajı konulabilir
        // Bir testten false sonucunu bekliyorsak .assertFalse() kullanırız. Yani negatif senaryolarda.

        int number = 12;
        assertFalse(number > 25);
        assertFalse("Condition did not satisfied",number<25);
    }
    @Test
    public void assertNullNotNullMethods(){

        Integer number = null;
        assertNull(number);//Parantez içindeki değer null ise test geçer

        number = 5;//number artık null değil.
        assertNotNull(number);//Parantez içindeki değer null değil ise test geçer

        assertNull("Number is not null:", number);//number null olmadığı için test kalır

    }
    @Test
    public void assertSameMethod() {

        // Assert.assertSame() metodu içindeki 2 değerin referansları karşılaştırır.
        // Aynı referanslara sahiplerse, test geçer, değillerse test kalır

        String name1 = "John";
        String name2 = "John";//name1 ve name2 String pool'da aynı yeri işgal eder.
        String name3 = new String("John");//String pool içinde yeni bir yer açar. Yeni bir obje oluşur.

        assertSame(name1, name2);
        assertSame(name1, name3);

    }

    @Test
    public void assertNotSameMethod() {

        // Assert.assertNotSame() metodu içindeki 2 değerin referansları karşılaştırır.
        // Farklı referanslara sahiplerse, test geçer, aksi taktirde test kalır


        String name1 = "John";
        String name2 = "John";//name1 ve name2 String pool'da aynı yeri işgal eder.
        String name3 = new String("John");//String pool içinde yeni bir yer açar. Yeni bir obje oluşur.

        assertNotSame(name1, name3);
        assertNotSame("Referans are same: ",name1, name2);

    }

}
