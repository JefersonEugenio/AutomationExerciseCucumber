//package steps.login;
//
//import com.aventstack.extentreports.Status;
//import framework.tools.Screenshot;
//import framework.webDrivers.DriverManager;
//import io.cucumber.java.pt.Dado;
//import io.cucumber.java.pt.E;
//import io.cucumber.java.pt.Então;
//import io.cucumber.java.pt.Quando;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import static framework.tools.Report.extentTest;
//
//public class LoginAutomationExercise {
//
//    WebDriver driver = DriverManager.getDriver();
//
//    @Dado("que o usuario esta na pagina de login do sistema Automation Exercise")
//    public void queOUsuarioEstaNaPaginaDeLoginDoSistemaAutomationExercise() {
//        extentTest.log(Status.INFO, "A tela está página de login do sistema Automation Exercise");
//    }
//
//    @Quando("o usuario preenche o campo email com {string}")
//    public void oUsuarioPreencheOCampoEmailCom(String valor) {
//        driver.findElement(By.name("email")).sendKeys(valor);
//    }
//
//    @E("o usuario preenche o campo password com {string}")
//    public void oUsuarioPreencheOCampoPasswordCom(String valor) {
//        driver.findElement(By.name("password")).sendKeys(valor);
//    }
//
//    @E("o usuario clica no botao login")
//    public void oUsuarioClicaNoBotaoLogin() {
//        driver.findElement(By.cssSelector(".login-form .btn-default")).click();
//    }
//
//    @Então("o sistema autentica o usuario")
//    public void oSistemaAutenticaOUsuario() throws InterruptedException {
//        Thread.sleep(2000);
//    }
//
//    @E("redireciona para a tela principal")
//    public void redirecionaParaATelaPrincipal() throws IllegalAccessException {
//        extentTest.log(Status.INFO, "Está acessando a tela de principal", Screenshot.screenshotBase64(driver));
//    }
//
//}
