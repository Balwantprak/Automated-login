package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

public abstract class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver driver() {
        return DriverFactory.getDriver();
    }
}
