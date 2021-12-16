package paralleltests;

import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public abstract class TestBase {
    protected ThreadLocal<WebDriver> driver;
    protected ThreadLocal<String> browserName;

    @Parameters("browser")
    @BeforeTest
    public void testSuiteInitialize(@Optional String browser) {
        System.out.println("Class init.....");
        browserName = new ThreadLocal<>();
        if (browser == null) {
            browser = "chrome";
        }
        browserName.set(browser);
    }

    @BeforeMethod
    public void initialize() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ThreadLocal<>();
        if (browserName.get().equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver(chromeOptions));
        } else {
            throw new UnsupportedOperationException(browserName.get() + " not found");
        }
    }

    @AfterMethod
    public void clean() {
        if (driver.get() != null) {
            driver.get().close();
        }
    }

    public void goTo(String url) {
        driver.get().get(url);
    }
}
