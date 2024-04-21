package tests.day09_testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C05_LocatelerIcinPageClassKullanimi {
    @Test
    public void aramaTesti(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = testotomasyonuPage.aramaSonucYaziElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

        Driver.quitDriver();

    }
}
