package tests.day09_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_NegatifLoginTesti {
    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //  uc farkli testmetho'unda asagidaki gorevleri
    //  gecerli email - gecersiz password
    //  gecersiz email - gecerli password
    //  gecersiz email - gecersiz password icin calistirin
    //2- account linkine basin
    //3- Kullanici email'i olarak istenen email girin
    //4- Kullanici sifresi olarak istenen sifre girin
    //5- Login butonuna basarak login olmayi deneyin
    //6- Basarili olarak giris yapilamadigini test edin


    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("unityverse@gmailcom");

        //4- Kullanici sifresi olarak gecersiz sifre girin
        testotomasyonuPage.passwordKutusu.sendKeys("4567890");

        //5- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //6- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecersiz email girin
        testotomasyonuPage.emailKutusu.sendKeys("unity@gmailcom");

        //4- Kullanici sifresi olarak gecerli sifre girin
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        //5- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //6- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecersiz email girin
        testotomasyonuPage.emailKutusu.sendKeys("unity@gmailcom");

        //4- Kullanici sifresi olarak gecersiz sifre girin
        testotomasyonuPage.passwordKutusu.sendKeys("4567890");

        //5- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //6- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.quitDriver();

    }
}
