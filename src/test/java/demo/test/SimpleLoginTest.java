package demo.test;

import static org.testng.Assert.assertEquals;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import demo.util.Log;

public class SimpleLoginTest extends BaseTest {

  private static Logger logger = LogManager.getLogger(SimpleLoginTest.class);

  // @BeforeClass(alwaysRun = true)
  // public void setUp() throws Exception {
  //
  // InputStream input = null;
  // input = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
  // prop.load(input);
  //
  // browser = prop.getProperty("browser");
  //
  // switch (browser) {
  // case "firefox":
  // System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
  // driver = new FirefoxDriver();
  // break;
  // case "chrome":
  // System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
  // driver = new ChromeDriver();
  // break;
  // default:
  // System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
  // driver = new FirefoxDriver();
  // }
  // // Firefox driver
  // // System.setProperty("webdriver.gecko.driver", "C:/gecko driver/geckodriver.exe");
  // // driver = new FirefoxDriver();
  //
  // // Chrome driver
  // // System.setProperty("webdriver.chrome.driver", "C:/gecko driver/chromedriver.exe");
  // // driver = new ChromeDriver();
  //
  // // baseUrl = "https://opensource-demo.orangehrmlive.com/";
  // driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")),
  // TimeUnit.SECONDS);
  // }
  boolean flag = false;

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get(prop.getProperty("baseUrl"));
    Log.startTestCase();
    driver.findElement(By.id("txtUsername")).click();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    logger.log(Level.INFO, "*********Enter Username*********");
    driver.findElement(By.id("divLogin")).click();
    driver.findElement(By.id("txtPassword")).click();
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    logger.log(Level.INFO, "*********Enter Password*********");
    driver.findElement(By.id("btnLogin")).click();
    logger.log(Level.INFO, "*********Click login Button*********");
    try {
      assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
      flag = true;
    } catch (Error e) {
      logger.log(Level.ERROR, "**** Could not find the text ***");
    }

    // check
    if (driver.findElement(By.id("welcome")).getText().equalsIgnoreCase("Welcome Admin1")) {
      flag = true;
    } else {
      captureScreenShot();
    }

    Assert.assertTrue(flag);

    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
    logger.log(Level.INFO, "*********Click logOut Button*********");
    Log.endTestCase();
  }
  // @AfterClass(alwaysRun = true)
  // public void tearDown() throws Exception {
  // driver.quit();
  // // driver.wait();
  // }
}
