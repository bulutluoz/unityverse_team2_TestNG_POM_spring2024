package tests.day12_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] aranacakKelimelerDataProvider() {

        String[][] aranacakUrunler = {{"phone"}, {"java"}, {"dress"}, {"baby"}, {"nutella"},
                                        {"samsung"}, {"cokokrem"}, {"iphone"}};

        return aranacakUrunler;
    }

    @Test(dataProvider = "aranacakKelimelerDataProvider")
    public void dataProviderIleTest(String aramaKelimesi){
        /*
            data provider datalari test method'u disindan tek tek test method'una yollamamizi saglar
            biz testimizi parametre ile calisacak sekilde hazirlariz

            sonra bize disardan parametreleri yollamasi icin bir data provider olustururuz
            @DataProvider notasyonuna sahip method'larin EN ONEMLI OZELLIGI
            iki katli bir array return etmesidir

            Dolayisiyla data provider'in bize parametre olarak yollamasini istedigimiz datalari
            iki katli bir array olarak olusturmaliyiz
         */

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // asagida verilen kelimeler icin arama yaptirip
        // hepsinde urun bulunabildigini test edin
        // aranacak kelimeler : phone, java, dress, baby, nutella, samsung, cokokrem, iphone

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu.sendKeys(aramaKelimesi + Keys.ENTER);

        Assert.assertTrue(testotomasyonuPage.bulunanSonucElementleriListesi.size()>0);

        Driver.quitDriver();
    }










    @Test
    public void test01(){

        /*
            Aranacak kelimeleri bir list olarak olusturup
            tek tek listedeki elemanlari aratmak istedigimizde
            bulamadigi ilk urunde assertion failed olacak
            TestNG calismayi durduracak
         */

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // asagida verilen kelimeler icin arama yaptirip
        // hepsinde urun bulunabildigini test edin
        // aranacak kelimeler : phone, java, dress, baby, nutella, samsung, cokokrem, iphone

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        String[] aranacakUrunler = {"phone", "java", "dress", "baby", "nutella", "samsung",
                                    "cokokrem", "iphone"};

        for (int i = 0; i < aranacakUrunler.length ; i++) {

            testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            Assert.assertTrue(testotomasyonuPage.bulunanSonucElementleriListesi.size()>0);

            ReusableMethods.bekle(1);

        }

        Driver.quitDriver();

    }
}
