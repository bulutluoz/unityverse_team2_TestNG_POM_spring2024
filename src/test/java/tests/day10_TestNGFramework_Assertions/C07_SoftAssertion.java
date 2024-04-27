package tests.day10_TestNGFramework_Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C07_SoftAssertion {

    @Test
    public void zeroWebAppTesti(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroWebAppUrl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("zeroWebAppUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,
                "anasayfa Url test datasi olarak verilen degerle ayni degil");

        // 3. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.anasayfaSigninButonu.click();

        // 4. Login kutusuna “username” yazin
        zeroWebAppPage.usernameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));
        // 5. Password kutusuna “password” yazin
        zeroWebAppPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));
        // 6. Sign in tusuna basin
        zeroWebAppPage.loginSayfasiSigninButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebAppPage.usernameDropdown.isDisplayed(),"Giris yapilamadi");

        // 9. Online banking menusunu tiklayin
        //10. Pay Bills sayfasina gidin
        //11. “Purchase Foreign Currency” tusuna basin
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        //13. “Currency” dropdown menusunden Eurozone’u secin
        //14. "Eurozone (euro)" secildigini dogrulayin
        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();

    }
}
