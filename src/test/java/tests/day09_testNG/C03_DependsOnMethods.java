package tests.day09_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;


import java.time.Duration;

public class C03_DependsOnMethods {

    // Test otomasyonu sayfasina gidip
    // asagidaki 3 testi farkli test method'larinda calistirin
    // 1- testotomasyonu sayfasina gittigimizi test edin
    // 2- phone icin arama yapip,
    //    arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu click yapip,
    //    acilan urun isminde case sensitive olmadan phone bulundugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test
    public void anasayfaTesti(){
        driver.get("https://www.testotomasyonu.com");

        // 1- testotomasyonu sayfasina gittigimizi test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
    }

    @Test(priority = 1)
    public void phoneAramaTesti(){

        // 2- phone icin arama yapip,
        //    arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);

        ReusableMethods.bekle(3);
    }

    @Test(priority = 2)
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu click yapip,
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();
        //    acilan sayfada, urun isminde case sensitive olmadan phone bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        ReusableMethods.bekle(3);
    }

}
