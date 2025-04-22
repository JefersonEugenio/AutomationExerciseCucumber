package steps.contato;

import com.aventstack.extentreports.Status;
import framework.supports.Fakers;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static framework.tools.Report.extentTest;

public class Contato {

    WebDriver driver = DriverManager.getDriver();
    Fakers fakers = new Fakers();

    @E("o usuario clica aba Contact us")
    public void oUsuarioClicaAbaContactUs() {
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a")).click();
        extentTest.log(Status.INFO, "A clica aba 'Signup/Login' e redirecionar para a tela de contato");
    }

    @E("que o usuario esta na pagina de contato do sistema Automation Exercise")
    public void queOUsuarioEstaNaPaginaDeContatoDoSistemaAutomationExercise() {
        extentTest.log(Status.INFO, "A tela está página de contato do sistema Automation Exercise");
    }

    @E("o usuario preenche o campo email aleatorio")
    public void oUsuarioPreencheOCampoEmailAleatorio() {
        driver.findElement(By.name("email")).sendKeys(fakers.getEmail());
        extentTest.log(Status.INFO, "O usuario preencheu o campo email");
    }

    @E("o usuario preenche o campo assunto")
    public void oUsuarioPreencheOCampoAssunto() {
        driver.findElement(By.name("subject")).sendKeys(fakers.getSubject());
        extentTest.log(Status.INFO, "O usuario preencheu o campo assunto");
    }

    @E("o usuario preenche o campo mensagem")
    public void oUsuarioPreencheOCampoMensagem() {
        driver.findElement(By.id("message")).sendKeys(fakers.getMessage());
        extentTest.log(Status.INFO, "O usuario preencheu o campo mensagem");
    }

    @E("o usuario seleciona arquivo")
    public void oUsuarioSelecionaArquivo() {
        WebElement uploadInput = driver.findElement(By.name("upload_file"));
        uploadInput.sendKeys("C:\\Users\\jeferson.lopes\\Desktop\\geral\\cambor.pdf");
        extentTest.log(Status.INFO, "O usuario selecionou o arquivo");
    }

    @Então("o usuario clica no botao submit")
    public void oUsuarioClicaNoBotaoSubmit() {
        driver.findElement(By.name("submit")).click();
        extentTest.log(Status.INFO, "O usuario clicou no botão submit");
    }

    @E("o usuario clica alerta no botao ok")
    public void oUsuarioClicaAlertaNoBotaoOk() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        extentTest.log(Status.INFO, "O usuario clicou alerta no botão ok");
    }

    @E("o sistema exibe a mensagem sucesso")
    public void oSistemaExibeAMensagemSucesso() throws IllegalAccessException {
        String mensagem = driver.findElement(By.cssSelector(".status")).getText();
        Assertions.assertEquals("Success! Your details have been submitted successfully." , mensagem);
        extentTest.log(Status.PASS, "A mensagem foi enviado com sucesso!", Screenshot.screenshotBase64(driver));
    }

    @E("o usuario clica no botao home")
    public void oUsuarioClicaNoBotaoHome() {
        driver.findElement(By.cssSelector(".btn-success")).click();
        extentTest.log(Status.INFO, "O usuario clicou no botão home");
    }
}
