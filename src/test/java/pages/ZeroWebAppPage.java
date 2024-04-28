package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {

    public ZeroWebAppPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement anasayfaSigninButonu;

    @FindBy(id = "user_login")
    public WebElement usernameKutusu;

    @FindBy(id = "user_password")
    public WebElement passwordKutusu;

    @FindBy(name = "submit")
    public WebElement loginSayfasiSigninButonu;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement usernameDropdown;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElementi;
}
