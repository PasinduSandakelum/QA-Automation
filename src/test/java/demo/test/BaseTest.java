package demo.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import demo.util.Function;

public class BaseTest {
  protected static WebDriver driver;

  private String browser;
  public static Properties prop = new Properties();
  private static String screenShotFolderPath =
      "E:/Workspaces/Eclips Workspace/Spring Workspace/automation/src/test/resources/"
          + "/src/test/resources/screenshots/";

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {

    InputStream input = null;
    input = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
    prop.load(input);

    browser = System.getProperty("browser");
    // browser = prop.getProperty("browser");

    switch (browser) {
      case "firefox":
        System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
        driver = new FirefoxDriver();
        break;
      case "chrome":
        System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
        driver = new ChromeDriver();
        break;
      default:
        System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
        driver = new FirefoxDriver();
    }
    driver.get(prop.getProperty("baseUrl"));
    driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")),
        TimeUnit.SECONDS);
  }

  public static String captureScreenShot() {
    String filename = Function.getTimeStamp("yyyy-MM-dd_HH:mm:ss") + ".jpg";
    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenshotFile, new File(screenShotFolderPath + filename));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return filename;

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    // driver.wait();
  }

}
