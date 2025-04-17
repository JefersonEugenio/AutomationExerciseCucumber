package framework.supports;

import com.aventstack.extentreports.Status;
import framework.tools.Report;
import framework.utils.CreateFolder;
import framework.webDrivers.DriverManager;
import framework.webDrivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static framework.tools.Report.extentTest;
import static framework.webDrivers.DriverFactory.getBrowser;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        CreateFolder.createFolder("main", "properties");
        String featureName = scenario.getUri().getPath();
        String scnarioName = scenario.getName();

        featureName = featureName.substring(featureName.lastIndexOf("/") + 1).replace(".feature", "");

        Report.configurarExtentReport(featureName, scnarioName);
        Report.createTest("Cenario: " + scnarioName);
        extentTest.log(Status.INFO, "Iniciado de teste");
        DriverManager.setDriver(getBrowser(Drivers.CHROME));
        DriverManager.getDriver().get("https://automationexercise.com");
    }

    @After
    public void tearDown() {
        extentTest.log(Status.INFO, "Finalizado de teste");
        Report.closeReport();
        DriverManager.quitDriver();
    }
}