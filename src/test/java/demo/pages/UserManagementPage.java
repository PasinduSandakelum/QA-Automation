package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserManagementPage extends BasePage {

  private WebElement lblHeader =
      driver.findElement(By.xpath("//*[@id=\"systemUser-information\"]/a"));

  UserManagementPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public boolean isUserManagementDisplayed() {
    boolean flag = false;
    try {
      lblHeader.isDisplayed();
      flag = true;
    } catch (Exception e) {
      flag = false;
    }

    return flag;

  }
}
