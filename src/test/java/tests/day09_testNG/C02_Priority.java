package tests.day09_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Priority {
    /*
        JUnit'de test method'larin hangi sira ile calisacagini ONGOREMEYIZ
        ve istedigimiz sirada calismasini SAGLAYAMAYIZ

        TestNG
        - test method'lari icin biz bir siralama vermezsek, isim sirasina gore calistirir
        - eger method'lar icin oncelik siralamasi yapmak istersek
          method'lara priority degeri atayabiliriz
          TestNG priority degerlerine bakip, kucukten buyuge dogru calistirir
        - Eger bazi method'lara priority atayip, bazilarina atamazsak
          priority atanmayanlar icin default olarak 0 degerini kabul eder
        - Eger priority degeri esit olan method'lar varsa
          priority degeri esit olanlari, kendi iclerinde harf sirasina uygun olarak calistirir

          @Ignore notasyonu yazilan method'lar
          TestNG tarafindan ignore edilir(gormezden gelinir) ve calistirilmaz

     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(priority = -9)
    public void testOtomasyonuTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // test otomasyonu sayfasinin acildigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }

    @Test
    public void youtubeTesti(){

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // youtube sayfasinin acildigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }

    @Test @Ignore
    public void walmartTesti(){

        // walmart anasayfaya gidin
        driver.get("https://www.walmart.com");

        // test otomasyonu sayfasinin acildigini test edin
        String expectedUrlIcerik = "walmart";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }



}
