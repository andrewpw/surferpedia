package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class SurferPage extends FluentPage {
  private String url;
  private String title;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   * @param title Title.
   */
  public SurferPage(WebDriver webDriver, int port, String title) {
    super(webDriver);
    this.url = "http://localhost:" + port;
    this.title = title;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo(title);
  }
  
  /**
   * Click edit.
   */
  public void clickEdit() {
    find("#edit").click();
  }
  
  /**
   * Click favorite.
   */
  public void clickFavorite() {
    find("#addFav").click();
  }
  
  /**
   * Go the User control page.
   */
  public void goToUserPage() {
    find("#userPage").click();
  }
  
  /**
   * Go to a Surfer on the search page results.
   * @param slug The slug of the Surfer.
   */
  public void goToSurfer(String slug) {
    find("#" + slug).click();
  }
}
