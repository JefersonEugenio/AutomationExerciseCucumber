package steps.login;

import com.aventstack.extentreports.Status;
import framework.supports.Fakers;
import framework.tools.Screenshot;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static framework.tools.Report.extentTest;

public class LoginAutomationExercise {

    WebDriver driver = DriverManager.getDriver();
    Fakers fakers = new Fakers();

    @Dado("que o usuario esta na pagina de login do sistema Automation Exercise")
    public void queOUsuarioEstaNaPaginaDeLoginDoSistemaAutomationExercise() {
        extentTest.log(Status.INFO, "A tela está página de login do sistema Automation Exercise");
    }

    @Quando("localizar a seção Login to your account e o usuario preenche o campo email com {string}")
    public void localizarASeçãoLoginToYourAccountEOUsuarioPreencheOCampoEmailCom(String valor) {
        List<WebElement> emails = driver.findElements(By.cssSelector("#form .container .row input[name=email]"));
        emails.get(0).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo email");
    }

    @E("localizar a seção New User Signup e o usuario preenche o campo email com {string}")
    public void localizarASeçãoNewUserSignupEOUsuarioPreencheOCampoEmailCom(String valor) {
        List<WebElement> emails = driver.findElements(By.cssSelector("#form .container .row input[name=email]"));
        emails.get(1).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo email");
    }

    @E("localizar a seção New User Signup e o usuario preenche o campo email com aleatório")
    public void localizarASeçãoNewUserSignupEOUsuarioPreencheOCampoEmailComAleatório() {
        List<WebElement> emails = driver.findElements(By.cssSelector("#form .container .row input[name=email]"));
        emails.get(1).sendKeys(fakers.getEmail());
        extentTest.log(Status.INFO, "O usuario preencheu o campo email");
    }

    @E("redireciona para a tela principal")
    public void redirecionaParaATelaPrincipal() throws IllegalAccessException {
        extentTest.log(Status.INFO, "Está acessando a tela de principal", Screenshot.screenshotBase64(driver));
    }

    @Quando("o usuario não preenche o campo email")
    public void oUsuarioNãoPreencheOCampoEmail() {
        extentTest.log(Status.INFO, "O usuario não preenche o campo email" );
    }

    @E("o usuario não preenche o campo password")
    public void oUsuarioNãoPreencheOCampoPassword() {
        extentTest.log(Status.INFO, "O usuario não preenche o campo password" );
    }

    @Então("o sistema exibe a mensagem Preenche este campo")
    public void oSistemaExibeAMensagemPreencheEsteCampo() throws IllegalAccessException {
        extentTest.log(Status.PASS, "O sistema exibir mensagem no campo que 'Preenche este campo.'", Screenshot.screenshotBase64(driver));
    }

    @Quando("o usuario preenche o campo nome com {string}")
    public void oUsuarioPreencheOCampoNomeCom(String valor) {
        driver.findElement(By.name("name")).sendKeys(valor);
        extentTest.log(Status.INFO, "O usuario preencheu o campo nome");
    }

    @Então("o sistema login exibe a mensagem {string}")
    public void oSistemaLoginExibeAMensagem(String valor) throws IllegalAccessException, InterruptedException {
        if (valor.contains("Your")) {
            String mensagemWeb = driver.findElement(By.cssSelector(".login-form form p")).getText();
            Assertions.assertEquals(valor, mensagemWeb);
            extentTest.log(Status.PASS, "O sistema exibir mensagem no campo que 'Your email or password is incorrect!'", Screenshot.screenshotBase64(driver));
        } else {
            String mensagemWeb = driver.findElement(By.cssSelector(".signup-form form p")).getText();
            Assertions.assertEquals(valor, mensagemWeb);
            extentTest.log(Status.PASS, "O sistema exibir mensagem no campo que 'Email Address already exist!!'", Screenshot.screenshotBase64(driver));
        }
    }

    @E("o usuario clica no botao signup")
    public void oUsuarioClicaNoBotaoSignup() {
        driver.findElement(By.cssSelector(".signup-form .btn-default")).click();
        extentTest.log(Status.INFO, "O usuario clicou no botão signup");
    }

    @E("localizar a seção New User Signup e o usuario não preenche o campo email")
    public void localizarASeçãoNewUserSignupEOUsuarioNãoPreencheOCampoEmail() {
        extentTest.log(Status.INFO, "O usuario não preenche o campo email");

    }

    @Quando("o usuario não preenche o campo nome")
    public void oUsuarioNãoPreencheOCampoNome() {
        extentTest.log(Status.INFO, "O usuario não preenche o campo nome");
    }

    @Então("redireciona para a tela cadastrar")
    public void redirecionaParaATelaCadastrar() throws IllegalAccessException {
        List<WebElement> elementos = driver.findElements(By.cssSelector(".login-form .title b"));
        for (WebElement elemento : elementos) {
            if (elemento.getText().equals("ENTER ACCOUNT INFORMATION")) {
                extentTest.log(Status.PASS, "A tela da página está na parte de cadastro", Screenshot.screenshotBase64(driver));
                break;
            } else {
                extentTest.log(Status.FAIL, "A tela da página não está na parte de cadastro", Screenshot.screenshotBase64(driver));
                break;
            }
        }
    }
}
