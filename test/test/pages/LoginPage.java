package test.pages;

import java.sql.Driver;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Login");
  }
  
  /**
   * Login as admin.
   */
  public void emptyLogin() {
    submit("#loginButton");
   }
  
  /**
   * Test login.
   */
  public void login() {    
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password"); 
    fill("#email").with(adminEmail);
    fill("#password").with(adminPassword);
    submit("#loginButton");
  }
  
  /**
   * Check login.
   */
  public void loginError() {
    fill("#email").with("Test");
    fill("#email").with("Password");
    submit("#loginButton");
  }
  
  
  /**
   * Set the form to the passed values, then submit it.
   * @param name The form name data.
   * @param gender The form gender value. 
   */
  public void submitForm(String name, String gender) {
    // Fill the input field with id "name" with the passed name string.
    fill("#name").with(name);
    // Find the menu with id "gender", and click the menu item equal to the passed gender string.
    find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
    //Submit the form whose id is "submit"
    submit("#submit");
  }
  
  
}
