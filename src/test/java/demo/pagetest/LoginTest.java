package demo.pagetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import demo.pages.DashboardPage;
import demo.pages.LoginPage;

public class LoginTest extends BaseTest {

  @Test
  public void verifyAdminLogin() {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
    Assert.assertTrue(dashboardPage.isDashboardDisplayed());

  }

}
