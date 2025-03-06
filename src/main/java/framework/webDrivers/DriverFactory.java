package framework.webDrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public static WebDriver getBrowser(Drivers tipo) {
        switch (tipo) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");

                options.addArguments("--user-data-dir=/tmp/chrome-profile"); // Diretório diferente
                options.addArguments("--disable-dev-shm-usage"); // Evita problemas com memória compartilhada
                options.addArguments("--no-sandbox"); // Ajuda em ambientes de CI/CD

//                options.addArguments("--headless=new"); // pode ser necessário rodar o Chrome sem interface gráfica
                return new ChromeDriver(options);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case EGDE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
        }
        return null;
    }
}
