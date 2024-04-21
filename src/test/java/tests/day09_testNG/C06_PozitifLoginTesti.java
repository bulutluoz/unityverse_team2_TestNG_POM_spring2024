package tests.day09_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C06_PozitifLoginTesti {

    @Test
    public void pozitifLogintesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin  unityverse@gmailcom
        testotomasyonuPage.emailKutusu.sendKeys("unityverse@gmailcom");

        //4- Kullanici sifresi olarak gecerli sifre girin 12345
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        //5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isEnabled());

        //7- logout olun ve sayfayi kapatin

        testotomasyonuPage.logoutButonu.click();

        Driver.quitDriver();
    }
}
