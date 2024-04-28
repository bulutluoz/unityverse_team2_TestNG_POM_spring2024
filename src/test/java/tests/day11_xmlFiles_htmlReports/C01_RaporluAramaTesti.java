package tests.day11_xmlFiles_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluAramaTesti extends TestBaseRapor {

    /*
        Normal olarak calisan bir test method'unu Raporlu hale getirmek icin
        1- class'i TestBaseRapor'a extends edelim
        2- extentTest objesi olusturup
           bu objeyi kullanarak raporda cikmasini istedigimiz bilgileri eklemeliyiz
     */

    @Test
    public void raporluAramaTesti(){

        extentTest = extentReports.createTest("soft assert ile urun arama testi",
                "Kullanici bulunmasi ve bulunmamasi gereken kelimeleri test eder");

        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");
        // 2. Title'in Test icerdigini dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),
                "title Test icermiyor");
        extentTest.pass("Title'in Test icerdigini dogrular");

        // 3. url'in testdatasi olarak verilen url ile ayni oldugunu dogrulayin
        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,
                "url test datasi olarak verilenden farkli");
        extentTest.pass("url'in testdatasi olarak verilen url ile ayni oldugunu dogrular");

        // 4. arama kutusunun kullanilabilir durumda oldugunu dogrulayin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        softAssert.assertTrue(testotomasyonuPage.aramaKutusu.isEnabled(),
                "Arama kutusu kullanilabilir durumda degil");
        extentTest.pass("arama kutusunun kullanilabilir durumda oldugunu dogrular");
        // 5. belirlenmis aranacak kelimeyi aratip urun bulundugunu dogrulayin
        testotomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenmis aranacak kelimeyi aratir");
        softAssert.assertTrue(testotomasyonuPage.bulunanSonucElementleriListesi.size()>0,
                "aranacak kelime aratildiginda urun bulunamadi");
        extentTest.pass("belirlenmis aranacak kelime icin urun bulundugunu dogrular");
        // 6. Nutella aratip, urun bulunamadigini dogrulayin

        testotomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Nutella aratir");
        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = testotomasyonuPage.aramaSonucYaziElementi.getText();

        softAssert.assertEquals(actualSonucYazisi,expectedSonucYazisi,
                "Nutella icin urun bulundu");
        extentTest.pass("Nutella icin urun bulunamadigini dogrular");

        softAssert.assertAll();

    }


}
