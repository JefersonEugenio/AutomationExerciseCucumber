package steps.cadastrar;

import com.aventstack.extentreports.Status;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static framework.tools.Report.extentTest;

public class CadastrarAutomationExercise {

    WebDriver driver = DriverManager.getDriver();

    @E("o usuario clica no botao de radio Mr.")
    public void oUsuarioClicaNoBotaoDeRadioMr() {
        driver.findElement(By.id("id_gender1")).click();
        extentTest.log(Status.INFO, "O usuario selecionou o radio 'Mr.'");
    }

    @E("o usuario preenche o campo criar uma senha com {string}")
    public void oUsuarioPreencheOCampoCriarUmaSenhaCom(String valor) {
        driver.findElement(By.id("password")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo a senha");
    }

    @E("o usuario seleciona DAY com {string}")
    public void oUsuarioSelecionaDAYCom(String valor) {
        new Select(driver.findElement(By.id("days"))).selectByValue(valor);
        extentTest.log(Status.INFO, "O usuario selecionou DIA");
    }

    @E("o usuario seleciona MONTH com {string}")
    public void oUsuarioSelecionaMONTHCom(String valor) {
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(valor);
        extentTest.log(Status.INFO, "O usuario selecionou MÊS");
    }

    @E("o usuario seleciona YEAR com {string}")
    public void oUsuarioSelecionaYEARCom(String valor) {
        new Select(driver.findElement(By.id("years"))).selectByValue(valor);
        extentTest.log(Status.INFO, "O usuario selecionou ANO");
    }

    @E("o usuario clica no checkout SIGN UP FOR OUR NEWSLETTER!")
    public void oUsuarioClicaNoCheckoutSIGNUPFOROURNEWSLETTER() {
        driver.findElement(By.id("newsletter")).click();
        extentTest.log(Status.INFO, "O usuario clicou no checkout 'SIGN UP FOR OUR NEWSLETTER!'");
    }

    @E("o usuario clica no checkout RECEIVE SPECIAL OFFERS FROM OUR PARTNERS!")
    public void oUsuarioClicaNoCheckoutRECEIVESPECIALOFFERSFROMOURPARTNERS() {
        driver.findElement(By.id("optin")).click();
        extentTest.log(Status.INFO, "O usuario clicou no checkout 'RECEIVE SPECIAL OFFERS FROM OUR PARTNERS!'");
    }

    @E("o usuario preenche o campo primeiro nome com {string}")
    public void oUsuarioPreencheOCampoPrimeiroNomeCom(String valor) {
        driver.findElement(By.id("first_name")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'First name'");
    }

    @E("o usuario preenche o campo sobrenome com {string}")
    public void oUsuarioPreencheOCampoSobrenomeCom(String valor) {
        driver.findElement(By.id("last_name")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'Last name'");
    }

    @E("o usuario preenche o campo company com {string}")
    public void oUsuarioPreencheOCampoCompanyCom(String valor) {
        driver.findElement(By.id("company")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'Company'");
    }

    @E("o usuario preenche o campo address com {string}")
    public void oUsuarioPreencheOCampoAddressCom(String valor) {
        driver.findElement(By.id("address1")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'Address'");
    }

    @E("o usuario seleciona COUNTRY com {string}")
    public void oUsuarioSelecionaCOUNTRYCom(String valor) {
        new Select(driver.findElement(By.id("country"))).selectByVisibleText(valor);
        extentTest.log(Status.INFO, "O usuario selecionou 'Country'");
    }

    @E("o usuario preenche o campo state com {string}")
    public void oUsuarioPreencheOCampoStateCom(String valor) {
        driver.findElement(By.id("state")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'state'");
    }

    @E("o usuario preenche o campo city com {string}")
    public void oUsuarioPreencheOCampoCityCom(String valor) {
        driver.findElement(By.id("city")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'city'");
    }

    @E("o usuario preenche o campo zipcode com {string}")
    public void oUsuarioPreencheOCampoZipcodeCom(String valor) {
        driver.findElement(By.id("zipcode")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'zipcode'");
    }

    @E("o usuario preenche o campo mobile number com {string}")
    public void oUsuarioPreencheOCampoMobileNumberCom(String valor) {
        driver.findElement(By.id("mobile_number")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo 'moblie number'");
    }

    @Então("o usuario clica no botao Create Account")
    public void oUsuarioClicaNoBotaoCreateAccount() {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
        extentTest.log(Status.INFO, "O usuario clicou no botão 'Create Account'");
    }
}
