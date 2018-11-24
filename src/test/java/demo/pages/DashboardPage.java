package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

  private WebElement lblHeader = driver.findElement(By.xpath("//h1"));
  private WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));

  public DashboardPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public boolean isDashboardDisplayed() {
    boolean flag = false;
    try {
      lblHeader.isDisplayed();
      flag = true;
    } catch (Exception e) {
      flag = false;
    }

    return flag;

  }

  public UserManagementPage navigateToUserManagement() {

    menuAdmin.click();
    return new UserManagementPage(driver);
  }

}
