package topics;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C44_FileExist {
/*

Bilgisayarımızdaki bir dosyanın varlığını test etmek için önce o dosyaya erişmemiz gerekmektedir.
Java'da dosyaya erişmek için dosya yoluna -pathine ihtiyacımız vardır.
Her bilgisayarın kullanıcı adı farklı olduğundan masaüstü dosya yolu da birbirinden farklı olacaktır.
Testlerimizin tüm bilgisayarda çalışması için dosya yolunu DİNAMİK hale getirmek zorundayız.

 Files.exists(Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder.
*/

    @Test
    public void fileExistTest(){
        //Masaüstündeki Flower.bmp dosyasnın varlığını test edelim.
        String userHome = System.getProperty("user.home");//Kullanıcı adına kadar(dahil) olan yolu verir.
        boolean isFlowerExist = Files.exists(Path.of(userHome+"/Desktop/Flower.bmp"));//kodun dinamik olabilmesi için, dosya yolunun dinamik yazılması gerekir.
        assertTrue(isFlowerExist);

//        //Masaüstündeki Bird.bmp dosyasnın olmadığını test edelim.
        boolean isBirdExist = Files.exists(Path.of(userHome+"/Desktop/Bird.bmp"));
        assertFalse(isBirdExist);
//
//        //Projede bulunan bir dosyanın varlığını test edelim.
        String userDir = System.getProperty("user.dir");//Projenin adı dahil yolunu verir.
        boolean isAddressesExist = Files.exists(Path.of(userDir+"/Addresses.txt"));
        assertTrue(isAddressesExist);

    }

}
