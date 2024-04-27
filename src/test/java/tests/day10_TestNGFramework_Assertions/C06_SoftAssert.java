package tests.day10_TestNGFramework_Assertions;

import org.testng.annotations.Test;

public class C06_SoftAssert {

    @Test
    public void softAssertionTesti(){

        /*
            JUnit'te ve suana kadar TestNG'de yaptigimiz assertion'larda
            ilk failed olan assertion'da kod calismayi durduruyor
            ve bize hata mesaji veriyor

            TestNG assertion konusunda bize 2 alternatif sunar
            1- Bugune kadar yaptigimiz gibi yapmaya devam etmek
               Ancak bu yontemle assertion yaptigimizda
               bir method'un icinde birden fazla failed olan assertion varsa
               bize sadece ilkini verir,
               ilkini duzelttikten sonra yola devam edip varsa diger assertion hatalarini verir

            2- SoftAssert
               SoftAssert ile assertion'lari yapmaya basladigimizda
               biz RAPORLA diyene kadar,
               assertion'lar failed olsa da kod calismaya devam eder
               biz RAPORLA dedigimizde
               yaptigi tum assertion'lari raporlar
               ve failed olan varsa exception firlatip calismayi durdurur.

         */

        // testotomasyonu anasayfaya gidin

        // testotomasyonu sayfasina gittiginizi test edin

        // belirlenen aranacak kelime icin arama yapin

        // arama sonuclarinin, belirlenen min.arama sayisindan fazla oldugunu test edin

        // ilk urunu tiklayin

        // acilan urun sayfasindaki, urun isminde
        // case sensitive olmadan belirlenmis aranacak kelime gectigini test edin

        // sayfayi kapatin


    }
}
