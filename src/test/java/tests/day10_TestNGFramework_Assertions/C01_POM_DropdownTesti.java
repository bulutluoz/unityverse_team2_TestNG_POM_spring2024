package tests.day10_TestNGFramework_Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C01_POM_DropdownTesti {

    @Test
    public void test01(){
        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();

        Select selectGun = new Select(testOtomasyonuFormPage.gunDropdownElementi);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        Select selectAy = new Select(testOtomasyonuFormPage.ayDropdownElementi);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        Select selectYil = new Select(testOtomasyonuFormPage.yilDropdownElementi);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin

        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> ayOptionElementleriListesi  = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOptionElementleriListesi));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedListeBoyutu = 13;
        int actualListeBoyutu = ayOptionElementleriListesi.size();

        Assert.assertEquals(actualListeBoyutu,expectedListeBoyutu);


        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
