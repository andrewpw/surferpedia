package test.pages;

import models.SurferDB;
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
public class NewSurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Manage Surfer");
  }
  
  /**
   * Create a new surfer.
   * @param name Name.
   * @param hometown Hometown.
   * @param country Country.
   * @param carouselURL CarouselURL.
   * @param bioURL BioURL.
   * @param bio Bio.
   * @param slug Slug.
   * @param type Type.
   * @param footstyle Footstyle.
   */
  public void createSurfer(String name, String hometown, String country, String carouselURL, String bioURL, String bio,
      String slug, String type, String footstyle) {
    fill("#name").with(name);
    fill("#hometown").with(hometown);
    fill("#country").with(country);
    fill("#carouselURL").with(carouselURL);
    fill("#bioURL").with(bioURL);
    fill("#bio").with(bio);
    fill("#slug").with(slug);
    find("select", withId().equalTo("type")).find("option", withText().equalTo(type)).click();
    find("radio", withId().equalTo("footstyle")).find("option", withText().equalTo(footstyle)).click();
    submit("#submit");
  }  

  /**
   * Create a new surfer.
   * @param newName New name.
   */
  public void editSurferName(String newName) {
    fill("#name").with(newName);
    submit("#submit");
  }  

}
