package steps.fluxo;

import com.aventstack.extentreports.Status;
import framework.tools.Screenshot;
import framework.utils.ProdutoProperties;
import framework.webDrivers.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void oUsuarioEscolheOProdutoEClicaNoBotaoAddToCart(String produto) {
        List<WebElement> elementos = driver.findElements(By.cssSelector("div > div.single-products > div.productinfo > p"));
        for (WebElement elemento : elementos) {
            String produtoNome = elemento.getText();
            WebElement precos = elemento.findElement(By.xpath("./preceding-sibling::h2"));
            String produtoPreco = precos.getText();
            if (produtoNome.contains(produto)) {
                ProdutoProperties.salvarProduto("Nome.Produto", produtoNome);
                ProdutoProperties.salvarProduto("Preco.Produto", produtoPreco);
                extentTest.log(Status.INFO, "O usuario escolheu o produto: " + produtoNome + " " + produtoPreco);
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

    @E("Clica no botão Proceed To Checkout")
    public void clicaNoBotãoProceedToCheckout() {
        driver.findElement(By.cssSelector("#do_action .container .btn")).click();
        extentTest.log(Status.INFO, "Clica no botão 'Proceed To Checkout'");
    }

    @E("Validacao nome do produto")
    public void validacaoNomeDoProduto() {
        String nomeProduto = driver.findElement(By.cssSelector("#product-1 h4 a")).getText();
        String nomeProdutoCliente = ProdutoProperties.obterProdutoRetorno("Nome.Produto");
        Assertions.assertEquals(nomeProduto, nomeProdutoCliente);
        extentTest.log(Status.PASS, "O usuário selecionou o produto corretamente, e o nome exibido no carrinho corresponde ao esperado");
    }

    @E("Validacao preco do produto")
    public void validacaoPrecoDoProduto() {
        String nomePreco = driver.findElement(By.cssSelector("#product-1 .cart_price p")).getText();
        String nomePrecoCliente = ProdutoProperties.obterProdutoRetorno("Preco.Produto");
        Assertions.assertEquals(nomePreco, nomePrecoCliente);
        extentTest.log(Status.PASS, "O usuário selecionou o produto corretamente, e o preço exibido no carrinho corresponde ao esperado");
    }

    @E("Validacao quantidade do produto")
    public void validacaoQuantidadeDoProduto() {
        String quantidadeProduto = driver.findElement(By.cssSelector("#product-1 .cart_quantity button")).getText();
        ProdutoProperties.salvarProduto("Quantidade.Produto", quantidadeProduto);
        extentTest.log(Status.INFO, "Quantidade do produto no carrinho: " + quantidadeProduto);
    }

    @E("Validacao total do produto")
    public void validacaoTotalDoProduto() throws IllegalAccessException {
        String strPreco = ProdutoProperties.obterProdutoRetorno("Preco.Produto");
        strPreco = strPreco.replaceAll("[^0-9]", "");
        int intPreco = Integer.parseInt(strPreco);
        String strQty = ProdutoProperties.obterProdutoRetorno("Quantidade.Produto");
        int intQty = Integer.parseInt(strQty);
        int total = intPreco*intQty;
        String totalPreco = driver.findElement(By.cssSelector("#product-1 .cart_total p")).getText();
        WebElement element = driver.findElement(By.cssSelector("#product-1 .cart_total p"));
        Assertions.assertEquals("Rs. " + total, totalPreco);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        extentTest.log(Status.PASS, "O produto foi validado corretamente e o total exibido no carrinho corresponde ao esperado", Screenshot.screenshotBase64(driver));
    }

    @E("Clicar no botao Place Order")
    public void clicarNoBotaoPlaceOrder() {
        driver.findElement(By.cssSelector("#cart_items .container .btn")).click();
        extentTest.log(Status.INFO, "Clica no botão 'Place Order'");
    }

    @E("o usuario preenche o campo nome do cartao {string}")
    public void oUsuarioPreencheOCampoNomeDoCartao(String nome) {
        driver.findElement(By.name("name_on_card")).sendKeys(nome);
        extentTest.log(Status.INFO, "O usuário preencheu o nome " + nome + " no campo do cartão");
    }

    @E("o usuario preenche o campo numero do cartao {string}")
    public void oUsuarioPreencheOCampoNumeroDoCartao(String numero) {
        driver.findElement(By.name("card_number")).sendKeys(numero);
        extentTest.log(Status.INFO, "O usuário preencheu o numero " + numero + " no campo do cartão");
    }

    @E("o usuario preenche o campo CVC do cartao {string}")
    public void oUsuarioPreencheOCampoCVCDoCartao(String cvc) {
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        extentTest.log(Status.INFO, "O usuário preencheu o CVC " + cvc + " no campo do cartão");
    }

    @E("o usuario preenche o campo mes do cartao {string}")
    public void oUsuarioPreencheOCampoMesDoCartao(String mes) {
        driver.findElement(By.name("expiry_month")).sendKeys(mes);
        extentTest.log(Status.INFO, "O usuário preencheu o mes " + mes + " no campo do cartão");
    }

    @E("o usuario preenche o campo ano do cartao {string}")
    public void oUsuarioPreencheOCampoAnoDoCartao(String ano) {
        driver.findElement(By.name("expiry_year")).sendKeys(ano);
        extentTest.log(Status.INFO, "O usuário preencheu o ano " + ano + " no campo do cartão");
    }

    @E("Clica no botao Pay and Confirm Order")
    public void clicaNoBotaoPayAndConfirmOrder() {
        driver.findElement(By.id("submit")).click();
        extentTest.log(Status.INFO, "Clica no botão 'Pay and Confirm Order'");
    }

    @Então("o sistema exibe a mensagem {string}")
    public void oSistemaExibeAMensagem(String mensagem) throws IllegalAccessException {
        String mensagemWeb = driver.findElement(By.cssSelector("#form b")).getText();
        Assertions.assertEquals(mensagem, mensagemWeb);
        extentTest.log(Status.PASS, "Operação concluída com sucesso", Screenshot.screenshotBase64(driver));
    }

    @E("o usuario clica no botao Continue")
    public void oUsuarioClicaNoBotaoContinue() {
        driver.findElement(By.cssSelector("#form .pull-right .btn")).click();
        extentTest.log(Status.INFO, "Clica no botão 'Continue'");
    }

}
