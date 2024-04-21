package tests.day09_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverClassKullanimi {

    @Test
    public void aramaTesti(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucYaziElementi = Driver.getDriver().findElement(By.className("product-count-text"));

        System.out.println(aramaSonucYaziElementi.getText());


        ReusableMethods.bekle(4);
        Driver.quitDriver();

    }
}
