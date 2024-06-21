package topics;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C21_JavaFaker {

    //Fake Data = Mock Data 🡪 Gerçek olmayan verilerdir.
    //Faker Class: Gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.

    @Test
    public void fakerTest() {
        //Faker objesi oluştur
        Faker faker = new Faker();

        //Obje ile sahte veri üret
        //Firstname
        System.out.println(faker.name().firstName());

        //Lastname
        System.out.println(faker.name().lastName());

        //Fullname
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().nameWithMiddle());//3 isimli

        //SSN
        System.out.println(faker.idNumber().ssnValid());

        //Address
        System.out.println(faker.address().city());
        System.out.println(faker.address().streetPrefix());//sokak adı
        System.out.println(faker.address().country());
        System.out.println(faker.address().buildingNumber());//bina no
        System.out.println(faker.address().timeZone());
        System.out.println(faker.address().zipCode());

        //Phone Number
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.phoneNumber().subscriberNumber());
        System.out.println(faker.phoneNumber().subscriberNumber(8));

        //Number
        System.out.println(faker.number().digit());
        System.out.println(faker.number().digits(15));
        System.out.println(faker.number().numberBetween(1000000, 10000000));//arasında sayı verir

        //Internet
        System.out.println(faker.internet().image());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().emailAddress("johndoe"));
        System.out.println(faker.internet().url());
        System.out.println(faker.internet().password());

        // Faker.instance().name().firstName(); --> instance() static method ile obje oluşturmadan fake data üretebilrsiniz.************

        //Lorem
        System.out.println(Faker.instance().lorem().characters());
        System.out.println(Faker.instance().lorem().paragraph());
        System.out.println(Faker.instance().lorem().paragraphs(3));
        System.out.println(Faker.instance().lorem().sentence(3));

        //lordOfTheRings
        System.out.println(Faker.instance().lordOfTheRings().character());

    }

}