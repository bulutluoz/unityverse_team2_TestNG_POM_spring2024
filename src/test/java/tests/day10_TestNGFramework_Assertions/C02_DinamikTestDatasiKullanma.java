package tests.day10_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DinamikTestDatasiKullanma {

    @Test
    public void dinamikAramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // ConfigReader.getProperty("toUrl") ==> https://www.testotomasyonu.com/

        // belirlenmis olan arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")
                                                    + Keys.ENTER);
        //ConfigReader.getProperty("toAranacakKelime") ==> phone

        // belirlenmis arama kelimesi icin istenen minimum sonuc sayisindan
        // daha fazla sonuc bulundugunu test edin

        int expectedMinSonucSayisi = Integer.parseInt(ConfigReader.getProperty("minSonucSayisi")); // 2
        int actualSonucSayisi = testotomasyonuPage.bulunanSonucElementleriListesi.size(); // 4

        ReusableMethods.bekle(4);

        Assert.assertTrue(actualSonucSayisi >= expectedMinSonucSayisi);

        // sayfayi kapatin
        Driver.quitDriver();

    }
}
