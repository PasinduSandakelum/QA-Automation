package demo.pagetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import demo.pages.DashboardPage;
import demo.pages.LoginPage;
import demo.pages.UserManagementPage;

public class UserManagementViewTest extends BaseTest {

  @Test
  public void verifyUserManagementView() {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
    UserManagementPage managementPage = dashboardPage.navigateToUserManagement();
    Assert.assertTrue(managementPage.isUserManagementDisplayed());

  }

}
