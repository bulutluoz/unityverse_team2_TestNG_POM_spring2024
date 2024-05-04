package tests.day12_dataProvider;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderIleNegatifLoginTesti {

    @DataProvider
    public static Object[][] kullaniciBilgileriDataProvider() {
        String[][] kullaniciBilgileriArrayi = {
                {"banu@gmail.com",     "898989"},
                {"sedat@yahoo.com",    "989887"},
                {"orkong@tmail.com",   "122334"},
                {"unityverse@gmailcom",  "12345"},
                {"arzu@senmail.com",   "676767"},
                {"mehmet@mynet.com",   "878987"}
        };

        return kullaniciBilgileriArrayi;
    }

    // testotomasyonu anasayfaya gidin
    // asagida liste olarak verilen kullanici adi ve sifreler ile
    // giris yapilamadigini test edin
    //    banu@gmail.com     898989
    //    sedat@yahoo.com    989887
    //    orkong@tmail.com   122334
    //    fatih@hotmail.com  454545
    //    arzu@senmail.com   676767
    //    mehmet@mynet.com   878987

    @Test(dataProvider = "kullaniciBilgileriDataProvider")
    public void cokluNegatifLoginTesti(String email , String password){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // verilen email ve sifreleri girin
        testotomasyonuPage.emailKutusu.sendKeys(email);
        testotomasyonuPage.passwordKutusu.sendKeys(password);

        // login butonuna basin
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        // giris yapilamadigini test edin

        try {
            Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        } catch (NoSuchElementException e) { // istemedigimiz bir durum olustu ve giris yapildi

            testotomasyonuPage.logoutButonu.click();
            // sonraki kullanici bilgileri ile testin calismasi icin logout olacak

            // try-catch ile exception'i handle ettigimiz icin
            // failed olan testi Passed haline dondurduk
            // yeniden testi failed haline getirelim

            Assert.assertTrue(false); // %100 failed olacak bir assertion yazdik

        }

        Driver.quitDriver();

    }


}
