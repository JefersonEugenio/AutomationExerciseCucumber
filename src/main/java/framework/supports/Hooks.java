package framework.supports;

import framework.webDrivers.DriverManager;
import framework.webDrivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static framework.webDrivers.DriverFactory.getBrowser;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.setDriver(getBrowser(Drivers.CHROME));
        DriverManager.getDriver().get("https://automationexercise.com/login");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
