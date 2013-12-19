package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class UserPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public UserPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).contains("User - ");
  }
  
  /**
   * Check if logged in.
   * @return True if logged in, false if logged out.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  /**
   * Click on delete button.
   * @param slug Slug.
   */
  public void deleteFavorite(String slug) {
    find("#deleteFav-" + slug).click();
  }
  
}
