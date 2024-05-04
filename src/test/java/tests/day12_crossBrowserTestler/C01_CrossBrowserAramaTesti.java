package tests.day12_crossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

import java.util.List;

public class C01_CrossBrowserAramaTesti extends TestBaseCross {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin

        driver.get(ConfigReader.getProperty("toUrl"));

        // arama kutusuna belirlenmis arama kelimesini yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanSonucElementleriList =
                driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanSonucElementleriList.size() > 0);

    }
}
