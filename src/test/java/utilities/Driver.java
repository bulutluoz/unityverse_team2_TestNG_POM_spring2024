package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    // PageObjectModel (POM) dizayn edenler, WebDriver objesi olusturmak icin
    // bir method olusturmayi tercih etmisler
    // boylece her class'da extends kullanma mecburiyetimiz kalkmis olur

    public static WebDriver driver;

    public static WebDriver getDriver(){
        /*
            Bu method her kullanildiginda
            driver = new ChromeDriver(); satiri calisirsa, her seferinde yeni bir window olusturur

            bu sorunu cozmek icin,
            getDriver() ilk defa kullanildiginda driver = new ChromeDriver(); calismali,
            sonraki kullanimlarda driver = new ChromeDriver(); satiri calismamali
         */

        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;

    }


    public static void quitDriver(){
        driver.quit();
    }
}
