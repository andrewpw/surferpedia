package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Index");
  }
  
  /**
   * Click search button.
   */
  public void clickSearchButton() {
    submit("#search");
  }
  
  /**
   * Fill data of search form.
   * @param surferName Search term.
   * @param type Surfer type.
   * @param country Surfer country.
   */
  public void fillSearch(String surferName, String type, String country) {
    fill("#searchTerm").with(surferName);
    find("select", withId().equalTo("type")).find("option", withText().equalTo(type)).click();
    find("select", withId().equalTo("country")).find("option", withText().equalTo(country)).click();
    submit("#search");
  }
  
  /**
   * Click login link.
   */
  public void goToLogin() {
   find("#login").click();
  }
  
  /**
   * Check if logged in.
   * @return True if logged in, false if logged out.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  /**
   * Go the User control page.
   */
  public void goToUserPage() {
    find("#userPage").click();
  }
  
  
}
