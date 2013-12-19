package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Rating;
import models.Surfer;
import models.UserInfo;
import models.UserInfoDB;

/**
 * Holds the form data for the surfer rating.
 * @author Andrew Pearson-Wood
 */
public class RatingFormData {
  
  /** rating. */
  public int rating;
  
  /** Surfer. */
  public Surfer surfer;
  
  /** UserInfo. */
  public UserInfo userInfo;
  
  /**
   * Blank constructor.
   */
  public RatingFormData() {
  }

  /**
   * Constructor.
   * @param rating the rating to add.
   */
  public RatingFormData(Rating rating) {
    this.rating = rating.getRating();
    this.surfer = rating.getSurfer();
    this.userInfo = rating.getUserInfo();
  }
  
  public List<ValidationError> validate() {
    return null;
  }
}
