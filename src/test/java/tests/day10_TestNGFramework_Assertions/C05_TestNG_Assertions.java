package tests.day10_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_TestNG_Assertions {

    @Test
    public void urunTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasina gittiginizi test edin

        String expectedurl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedurl);

        // belirlenen aranacak kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")
                                                                    + Keys.ENTER);

        // arama sonuclarinin, belirlenen min.arama sayisindan fazla oldugunu test edin

        int expectedMinAramaSonucu = Integer.parseInt(ConfigReader.getProperty("minSonucSayisi"));
        int actualAramaSonucSayisi = testotomasyonuPage.bulunanSonucElementleriListesi.size();

        Assert.assertTrue(actualAramaSonucSayisi>=expectedMinAramaSonucu);

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanSonucElementleriListesi.get(0).click();

        // acilan urun sayfasindaki, urun isminde
        // case sensitive olmadan belirlenmis aranacak kelime gectigini test edin

        String expectedUrunIsimIcerigi = ConfigReader.getProperty("toAranacakKelime")
                                                    .toLowerCase();
        String actualUrunIsmi = testotomasyonuPage
                                        .ilkUrunSayfasindakiIsimElementi
                                        .getText()
                                        .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        // sayfayi kapatin
        Driver.quitDriver();
    }
}
