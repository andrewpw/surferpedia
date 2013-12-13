package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;
import play.data.validation.ValidationError;

/**
 * Holds data for the Sign-up form.
 * @author eduardgamiao
 *
 */
public class SignupFormData {

  /** Name. */
  public String name;
  
  /** Email. */
  public String email;
  
  /** Password. */
  public String password;
  
  /**
   * Default Constructor.
   */
  public SignupFormData() {
    
  }
  
  /**
   * Constructor.
   * @param name The User's name.
   * @param email The User's email.
   * @param password The User's password.
   */
  public SignupFormData(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * Provide form validation for the Signup form.
   * @return Null if no errors, else a list of ValidationErrors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    if (email == null || email.length() == 0) {
      errors.add(new ValidationError("email", "Email is required."));
    }
    if (UserInfoDB.getUser(email) != null) {
      errors.add(new ValidationError("email", "The email \"" + email + "\" is already used."));
    }    
    if (password == null || password.length() == 0) {
      errors.add(new ValidationError("password", "Password is required."));
    }
    return errors.isEmpty() ? null : errors;
  }
}
