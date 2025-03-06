package framework.supports;

import com.aventstack.extentreports.Status;
import framework.tools.Report;
import framework.webDrivers.DriverManager;
import framework.webDrivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static framework.tools.Report.extentTest;
import static framework.webDrivers.DriverFactory.getBrowser;

public class Hooks {

    @Before
    public void setUp() {
        Report.configurarExtentReport();
        Report.createTest("Automation Exercise com Cucumber");
        extentTest.log(Status.INFO, "Iniciado de teste");
        DriverManager.setDriver(getBrowser(Drivers.CHROME));
        DriverManager.getDriver().get("https://automationexercise.com/login");
    }

    @After
    public void tearDown() {
        extentTest.log(Status.INFO, "Finalizado de teste");
        Report.closeReport();
        DriverManager.quitDriver();
    }
}
