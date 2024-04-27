package tests.day10_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_SoftAssert {

    @Test
    public void softAssertionTesti(){

        /*
            JUnit'te ve suana kadar TestNG'de yaptigimiz assertion'larda
            ilk failed olan assertion'da kod calismayi durduruyor
            ve bize hata mesaji veriyor

            TestNG assertion konusunda bize 2 alternatif sunar
            1- Bugune kadar yaptigimiz gibi yapmaya devam etmek
               Ancak bu yontemle assertion yaptigimizda
               bir method'un icinde birden fazla failed olan assertion varsa
               bize sadece ilkini verir,
               ilkini duzelttikten sonra yola devam edip varsa diger assertion hatalarini verir

            2- SoftAssert
               SoftAssert ile assertion'lari yapmaya basladigimizda
               biz RAPORLA diyene kadar,
               assertion'lar failed olsa da kod calismaya devam eder
               biz RAPORLA dedigimizde
               yaptigi tum assertion'lari raporlar
               ve failed olan varsa exception firlatip calismayi durdurur.

             - bu yonteme softAssert deyince,
               bugune kadar kullandigimiz Assert class'ina da Hard Assert ismi verilmistir
             - soft assert assertion'lar failed oldugunda yola devam ettikleri icin tercih edilebilir
               ancak failed olan her assertion'in yerini soylemediginden
               hatalarin yerini bulabilmek icin
               assertion'lara aciklama eklemekte fayda vardir
             - Eger assertion'lari yaptigimiz halde
               en sona assertall() demeyi unutursak
               assertion'lar failed olsa bile TEST PASSED diye sonuc verir

         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasina gittiginizi test edin

        SoftAssert softAssert = new SoftAssert();

        String expectedurl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedurl,"anasayfa url testi failed");

        // belirlenen aranacak kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonuclarinin, belirlenen min.arama sayisindan fazla oldugunu test edin

        int expectedMinAramaSonucu = Integer.parseInt(ConfigReader.getProperty("minSonucSayisi"));
        int actualAramaSonucSayisi = testotomasyonuPage.bulunanSonucElementleriListesi.size();

        softAssert.assertTrue(actualAramaSonucSayisi>=expectedMinAramaSonucu,"Arama sonuc sayisi belirlenen min sonuc sayisindan buyuk degil");

        // ilk urunu tiklayin
        testotomasyonuPage
                .bulunanSonucElementleriListesi
                .get(0)
                .click();

        // acilan urun sayfasindaki, urun isminde
        // case sensitive olmadan belirlenmis aranacak kelime gectigini test edin
        String expectedUrunIsimIcerigi = ConfigReader.getProperty("toAranacakKelime")
                .toLowerCase();
        String actualUrunIsmi = testotomasyonuPage
                .ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi),"urun ismi aranacak kelimeyi icermiyor");

        // softAssert'e raporla demek icin
        softAssert.assertAll();

        // sayfayi kapatin
        Driver.quitDriver();


    }
}
