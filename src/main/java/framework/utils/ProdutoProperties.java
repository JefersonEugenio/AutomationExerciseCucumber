package framework.utils;

import java.io.*;
import java.util.Properties;

public class ProdutoProperties {

    private static final String CAMINHO_RESOURCES = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "properties"
            + File.separator + "produto.properties";

    public static void salvarProduto(String chave, String valor) {
        Properties prop = new Properties();

        try (FileInputStream in = new FileInputStream(CAMINHO_RESOURCES)) {
            prop.load(in);
        } catch (FileNotFoundException e) {
            // Se o arquivo ainda não existe, não há problema (será criado depois)
        } catch (IOException e) {
            e.printStackTrace();
        }

        prop.setProperty(chave, valor);

        try (FileOutputStream out = new FileOutputStream(CAMINHO_RESOURCES)) {
            prop.store(out, "Dados do Produto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obterProdutoRetorno(String chave) {
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream(CAMINHO_RESOURCES)) {
            prop.load(in);
            return prop.getProperty(chave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
