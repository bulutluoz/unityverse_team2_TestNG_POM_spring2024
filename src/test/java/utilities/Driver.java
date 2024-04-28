package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
        PageObjectModel (POM) dizayn edenler, WebDriver objesi olusturmak icin
        bir method olusturmayi tercih etmisler
        boylece her class'da extends kullanma mecburiyetimiz kalkmis olur

        POM dizayn edenler, bu yontem disinda herhangi bir sekilde
        Driver class'inin ve driver objesinin kullanimini ENGELLEMEK icin
        SINGLETON PATTERN kullanmayi tercih etmislerdir

        Singleton pattern, bir class'dan obje olusturulmasini
        ve olusturulacak obje ile bu class'dan ozelliklerin kullanilmasini ENGELLEMEK
        icin kullanilan yontemlerden biridir.
        Cok basit bir fikre dayanir.
        Eger biz herhangi bir class'in constructor'ini
        gorunur hale getirip, access modifier'ini PRIVATE yaparsak
        kimse bu class'dan bir obje OLUSTURAMAZ

     */

    private Driver(){

    }


    public static WebDriver driver;

    public static WebDriver getDriver(){
        /*
            Bu method her kullanildiginda
            driver = new ChromeDriver(); satiri calisirsa, her seferinde yeni bir window olusturur

            bu sorunu cozmek icin,
            getDriver() ilk defa kullanildiginda driver = new ChromeDriver(); calismali,
            sonraki kullanimlarda driver = new ChromeDriver(); satiri calismamali
         */

        String kullanilacakBrowser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (kullanilacakBrowser){

                case "firefox" :
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "safari" :
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                default:
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            }

        }

        return driver;

    }


    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
