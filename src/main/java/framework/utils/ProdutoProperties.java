package framework.utils;

import java.io.*;
import java.util.Properties;

public class ProdutoProperties {

    private static final String CAMINHO_ARQUIVO = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "properties"
            + File.separator + "Produtos.txt";

    public static void salvarProduto(String valor) {
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO, true)) {
            writer.write(valor + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Erro ao criar/escrever no arquivo.");
            e.printStackTrace();
        }
    }

    public static String obterProdutoRetorno(String chave) {
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream(CAMINHO_ARQUIVO)) {
            prop.load(in);
            return prop.getProperty(chave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
