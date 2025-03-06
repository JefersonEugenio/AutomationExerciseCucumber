package framework.webDrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public static boolean isHeadless;

    public static WebDriver getBrowser(Drivers tipo) {

        String headless = System.getProperty("headless", "false").toLowerCase();

        if (headless.equals("true") || headless.equals("false")) {
            isHeadless = Boolean.parseBoolean(headless);}
        else {
            throw new IllegalArgumentException("O parâmetro 'headless' aceita apenas valores booleanos: true ou false.");
        }

        switch (tipo) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                if (isHeadless) {
                    options.addArguments("--headless");
                }
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