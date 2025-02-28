package topics;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C55_Log4J {
/*
    - All: Günlük kaydını açar ve her şeyi günlüğe kaydeder.
    - DEBUG: Hata ayıklama bilgilerini yazdırır ve geliştirme aşamasında yardımcı olur.
    - INFO: Uygulamanın ilerleyişini vurgulayan bilgi mesajları yazdırır.
    - WARN: Hatalı ve beklenmeyen sistem davranışıyla ilgili bilgileri yazdırır.
    - ERROR: Sistemin devam etmesine izin verebilecek bir hata mesajı yazdırır.
    - FATAL: Uygulamanın çökmesine neden olan sistemin kritik bilgilerini yazdırır.
    - OFF: Kayıt yapılmaz, yani hiçbir şey günlüğe kaydedilmez.
*/

    @Test
    public void log4jTest() {

        Logger logger = LogManager.getLogger();

        logger.fatal("Fatal Message");//Defalut olarak ayarlama yapmadan yazdırılabilir.
        logger.error("Error Message");//Defalut olarak ayarlama yapmadan yazdırılabilir.
        logger.warn("Warn Message");//Ayarlama yapmadan yazdırılamazlar.
        logger.info("Info Message");//Ayarlama yapmadan yazdırılamazlar.
        logger.debug("Debug Message");//Ayarlama yapmadan yazdırılamazlar.
        logger.trace("Trace Message");//Ayarlama yapmadan yazdırılamazlar.


    }


}
