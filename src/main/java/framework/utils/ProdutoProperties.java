package framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ProdutoProperties {

    private static final String CAMINHO_RESOURCES = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "properties"
            + File.separator + "produto.properties";

    public static void salvarProduto(String nome, String preco) {
        Properties prop = new Properties();
        try (FileOutputStream out = new FileOutputStream(CAMINHO_RESOURCES)) {
            prop.setProperty("produto.nome", nome);
            prop.setProperty("produto.preco", preco);
            prop.store(out, "Dados do Produto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obterProdutoRetorno() {
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream(CAMINHO_RESOURCES)) {
            prop.load(in);
            return "Nome do produto: " + prop.getProperty("produto.nome") + ", preço do produto: " + prop.getProperty("produto.preco");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
