package test;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.ChangeLogPage;
import test.pages.IndexPage;
import test.pages.LoginPage;
import test.pages.NewSurferPage;
import test.pages.ResultPage;
import test.pages.SurferPage;
import test.pages.UserPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }
  
  /**
   * Check to see that a search submission goes to Results page.
   */
  @Test
  public void testSearchButtonGoesToResults() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.clickSearchButton();
        ResultPage resultPage = new ResultPage(browser.getDriver(), PORT);
        resultPage.isAt();
      }
    });
  }
  
  /**
   * Check to see error message pops up when no login information is provided.
   */
  @Test
  public void testLoginErrorWithoutInput() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) throws InterruptedException {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.emptyLogin();
        assertThat(browser.pageSource().contains("Login credentials not valid.")).isTrue();
      }
    });
  }
  
  /**
   * Check to see error message pops up when wrong login information is provided.
   */
  @Test
  public void testLoginErrorWithInput() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) throws InterruptedException {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.loginError();
        assertThat(browser.pageSource().contains("Login credentials not valid.")).isTrue();
      }
    });
  }
  
  /**
   * Check that login works and brings user to index page once logged in.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
      }
    });
  }
  
  /**
   * Test user control panel functions.
   */
  @Test
  public void testUserPersonalPageLinkInNavigationBar() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToUserPage();
        UserPage userPage = new UserPage(browser.getDriver(), PORT);
        userPage.isAt();
      }
    });    
  }

  /**
   * Test search functions.
   */
  @Test
  public void testSearchWidget() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.fillSearch("Bethany Hamilton", "Female", "United States");
        ResultPage resultPage = new ResultPage(browser.getDriver(), PORT);
        resultPage.isAt();
        assertThat(browser.pageSource().contains("1 result(s)")).isTrue();
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.fillSearch("Bethany Hamilton", "Male", "United States");
        resultPage.isAt();
        assertThat(browser.pageSource().contains("0 result(s)")).isTrue();
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.fillSearch("Bethany Hamilton", "Female", "Australia");
        resultPage.isAt();
        assertThat(browser.pageSource().contains("0 result(s)")).isTrue();
      }
    });    
  }
  
  /**
   * Test change log link.
   */
  @Test
  public void testChangeLogLink() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToChangeLog();
        ChangeLogPage changeLogPage = new ChangeLogPage(browser.getDriver(), PORT);
        changeLogPage.isAt();
      }
    });    
  }
  
  /**
   * Test new surfer creation.
   */
  @Test
  public void testNewSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.createSurfer("UniquePerson", "Mars", "United States", "hello.com/.jpg", "goodbye.com/.jpg", 
            "Hey a bio", "UniqueSlug", "Grom", "Regular");
        assertThat(browser.title().equals("UniquePerson")).isTrue();
      }
    });    
  }
  
  /**
   * Test Surfer edit function.
   */
  @Test
  public void testEditSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.createSurfer("UniquePerson", "Mars", "United States", "hello.com/.jpg", "goodbye.com/.jpg", 
            "Hey a bio", "UniqueSlug", "Grom", "Regular");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, "UniquePerson");
        surferPage.isAt();
        surferPage.clickEdit();
        newSurferPage.isAt();
        newSurferPage.editSurferName("AnotherUnique");
        assertThat(browser.title().equals("AnotherUnique")).isTrue();
      }
    });    
  }
 
  /**
   * Test favorite function.
   */
  @Test
  public void testFavoriteSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.createSurfer("UniquePerson", "Mars", "United States", "hello.com/.jpg", "goodbye.com/.jpg", 
            "Hey a bio", "UniqueSlug", "Grom", "Regular");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, "UniquePerson");
        surferPage.isAt();
        surferPage.clickFavorite();
        surferPage.isAt();
        surferPage.goToUserPage();
        UserPage userPage = new UserPage(browser.getDriver(), PORT);
        userPage.isAt();
        assertThat(browser.pageSource().contains("UniquePerson")).isTrue();
      }
    });    
  }
 
  /**
   * Test delete favorite function.
   */
  @Test
  public void testDeleteFavoriteSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        indexPage.isAt();
        indexPage.isLoggedIn();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.createSurfer("UniquePerson", "Mars", "United States", "hello.com/.jpg", "goodbye.com/.jpg", 
            "Hey a bio", "UniqueSlug", "Grom", "Regular");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, "UniquePerson");
        surferPage.isAt();
        surferPage.clickFavorite();
        surferPage.isAt();
        surferPage.goToUserPage();
        UserPage userPage = new UserPage(browser.getDriver(), PORT);
        userPage.isAt();
        assertThat(browser.pageSource().contains("UniquePerson")).isTrue();
        userPage.deleteFavorite("UniqueSlug");
        browser.goTo(indexPage);
        indexPage.goToUserPage();
        userPage.isAt();
        assertThat(browser.pageSource().contains("UniquePerson")).isFalse(); 
      }
    });    
  }
}
