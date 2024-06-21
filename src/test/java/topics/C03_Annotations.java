package topics;

import org.junit.*;

public class C03_Annotations {
/*
        *** ANNOTATIONS ***
        6 Temel Junit anotasyonu vardır.
    @Test: Bir metodun TEST CASE olarak işaretlenmesini sağlar.
    @Before: Her @Test anotasyonundan önce çalışır.
    @After: Her @Test anotasyonundan sonra çalışır.
    @BeforeClass: Bir sınıfın her çalıştırılmasından önce yalnızca bir kez çalışır.
    @AfterClass: Bir sınıfın her çalıştırılmasından sonra yalnızca bir kez çalışır.
    @Ignore: Bir test case'in atlanmasını sağlar.
*/
    @Before
    public void beforeMethod(){
        System.out.println("Before Methodu");
    }
    @After
    public void afterMethod(){
        System.out.println("After Methodu");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }

    @Test @Ignore
    public void test04(){
        System.out.println("Test 04");
    }

    @Test
    public void test05(){
        System.out.println("Test 05");
    }
}
