package controllers;

import java.util.Date;
import java.util.List;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.ShowSurfer;
import views.html.ManageSurfer;
import views.html.Updates;
import models.SurferDB;
import models.UpdateDB;
import models.UserInfo;
import models.UserInfoDB;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  
  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {  
    return ok(Index.render("Welcome to the home page.", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  @Security.Authenticated(Secured.class)
  public static Result newSurfer(){
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    SurferFormData surferFD = new SurferFormData();
    List<String> foot = SurferDB.getFootstyleList();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(surferFD);
    return ok(ManageSurfer.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferTypes.getTypes(), foot));
  }
  
  @Security.Authenticated(Secured.class)
  public static Result postSurfer(){
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      flash("error", "Please correct the form below.");
      List<String> foot = SurferDB.getFootstyleList();
      return badRequest(ManageSurfer.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferTypes.getTypes(), foot));
    }
    else {
      SurferFormData data = formData.get();
      flash("success", String.format("Successfully added %s", data.name));
      SurferDB.add(data.slug, data);
      return ok(ShowSurfer.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurfer(data.slug)));
    }
  }
  
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug){
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    SurferDB.deleteSurfer(slug);
    return ok(Index.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug){
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    SurferFormData surferFD = new SurferFormData(SurferDB.getSurfer(slug));
    List<String> foot = SurferDB.getFootstyleList();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(surferFD);
    return ok(ManageSurfer.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()) ,formData, SurferTypes.getTypes(SurferDB.getSurfer(slug).getType()), foot));
  }
  
  public static Result getSurfer(String slug){
    if (SurferDB.getSurfer(slug) != null){
      return ok(ShowSurfer.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()) ,SurferDB.getSurfer(slug)));
    }
    else { 
      return ok(Index.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
  }
  
  public static Result getUpdates(){
      return ok(Updates.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), UpdateDB.getUpdates()));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    //Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }
  
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();
    //Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
