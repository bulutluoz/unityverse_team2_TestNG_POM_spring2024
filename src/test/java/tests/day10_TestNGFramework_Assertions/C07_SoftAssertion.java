package tests.day10_TestNGFramework_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

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
        zeroWebAppPage.onlineBanking.click();
        //10. Pay Bills sayfasina gidin
        zeroWebAppPage.payBillsLinki.click();
        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseForeignCurrency.click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebAppPage.pcCurrencyDropdownElementi.isEnabled(),
                "Pc currency dropdown menu kullanilamiyor");
        //13. “Currency” dropdown menusunden Eurozone’u secin

        Select select = new Select(zeroWebAppPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");
        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,
                            "Currency olarak euro secilmemis");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,
                                    "Currency dropdown'da 16 option yok");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

        List<WebElement> dropdownMenuElementleriList = select.getOptions();
        List<String> dropdownOptionListStr = ReusableMethods.stringListeDonustur(dropdownMenuElementleriList);

        String expectedOption = "Canada (dollar)";
        softAssert.assertTrue(dropdownOptionListStr.contains(expectedOption),
                        "dropdown menu Canada (dollar) icermiyor");

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();

    }
}
