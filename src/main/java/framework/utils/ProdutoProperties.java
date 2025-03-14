package framework.utils;

import java.io.*;
import java.util.Properties;

public class ProdutoProperties {

    private static final String CAMINHO_ARQUIVO = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "properties"
            + File.separator + "produto.properties";

    public static void salvarProduto(String chave, String valor) {
        Properties prop = new Properties();
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {
            try {
                if (arquivo.createNewFile()) {
                }
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo de propriedades: " + e.getMessage());
                return;
            }
        }

        try (FileInputStream in = new FileInputStream(arquivo)) {
            prop.load(in);
        } catch (IOException e) {
            System.err.println("Aviso: Não foi possível carregar o arquivo de propriedades. Pode estar vazio ou não existir.");
        }
        prop.setProperty(chave, valor);

        try (FileOutputStream out = new FileOutputStream(CAMINHO_ARQUIVO)) {
            prop.store(out, "Dados do Produto");
        } catch (IOException e) {
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
