package steps.fluxo;

import com.aventstack.extentreports.Status;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static framework.tools.Report.extentTest;

public class FluxoDeComprar {

    WebDriver driver = DriverManager.getDriver();

    @Dado("que o usuario esta na pagina de principal do sistema Automation Exercise")
    public void queOUsuarioEstaNaPaginaDePrincipalDoSistemaAutomationExercise() {
        extentTest.log(Status.INFO, "A tela está página de principal do sistema Automation Exercise");
    }

    @E("o usuario clica aba Login")
    public void oUsuarioClicaAbaLogin() {
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")).click();
        extentTest.log(Status.INFO, "A clica aba 'Signup/Login' e redirecionar para a tela de login");
    }

    @Quando("o usuario preenche o campo email com {string}")
    public void oUsuarioPreencheOCampoEmailCom(String valor) {
        driver.findElement(By.name("email")).sendKeys(valor);
        extentTest.log(Status.INFO, "Preenche o email");
    }

    @E("o usuario preenche o campo password com {string}")
    public void oUsuarioPreencheOCampoPasswordCom(String valor) {
        driver.findElement(By.name("password")).sendKeys(valor);
        extentTest.log(Status.INFO, "Preenche a senha");
    }

    @E("o usuario clica no botao login")
    public void oUsuarioClicaNoBotaoLogin() {
        driver.findElement(By.cssSelector(".login-form form button")).click();
        extentTest.log(Status.INFO, "Clica no botão Login");
    }

    @E("o sistema autentica o usuario e redireciona para a tela principal")
    public void oSistemaAutenticaOUsuarioERedirecionaParaATelaPrincipal() {
        extentTest.log(Status.INFO, "O sistema está autenticado usuário e tela de principal");
    }

    @E("o usuario escolhe o produto {string} e clica no botao Add to cart")
    public void oUsuarioEscolheOProdutoEClicaNoBotaoAddToCart(String valor) {
        List<WebElement> elementos = driver.findElements(By.cssSelector("div > div.single-products > div.productinfo > p"));
        for (WebElement elemento : elementos) {
            String texto = elemento.getText();
            if (texto.contains(valor)) {
                extentTest.log(Status.INFO, "O usuario escolheu o produto: " + valor);
                WebElement botao = elemento.findElement(By.xpath("./following-sibling::a"));
                botao.click();
                extentTest.log(Status.INFO, "Clica no botão 'Add to Cart'");
                break;
            }
        }
    }

    @E("Clica no link View Cart")
    public void clicaNoLinkViewCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.findElement(By.cssSelector("#cartModal a")).click();
        extentTest.log(Status.INFO, "Clica no link 'View Cart'");
    }

    @E("Validacao nome do produto")
    public void validacaoNomeDoProduto() {
    }

    @E("Validacao preco do produto")
    public void validacaoPrecoDoProduto() {
    }

    @E("Validacao quantidade do produto")
    public void validacaoQuantidadeDoProduto() {
    }

    @E("Validacao total do produto")
    public void validacaoTotalDoProduto() {
    }

    @E("Clicar no botao Place Order")
    public void clicarNoBotaoPlaceOrder() {
    }

    @E("o usuario preenche o campo nome do cartao {string}")
    public void oUsuarioPreencheOCampoNomeDoCartao(String arg0) {
    }

    @E("o usuario preenche o campo numero do cartao {string}")
    public void oUsuarioPreencheOCampoNumeroDoCartao(String arg0) {
    }

    @E("o usuario preenche o campo CVC do cartao {string}")
    public void oUsuarioPreencheOCampoCVCDoCartao(String arg0) {
    }

    @E("o usuario preenche o campo mes do cartao {string}")
    public void oUsuarioPreencheOCampoMesDoCartao(String arg0) {
    }

    @E("o usuario preenche o campo ano do cartao {string}")
    public void oUsuarioPreencheOCampoAnoDoCartao(String arg0) {
    }

    @E("Clica no botao {string}")
    public void clicaNoBotao(String arg0) {
    }

    @Então("o sistema exibe a mensagem {string}")
    public void oSistemaExibeAMensagem(String arg0) {
    }

    @E("o usuario clica no botao {string}")
    public void oUsuarioClicaNoBotao(String arg0) {
    }

}
