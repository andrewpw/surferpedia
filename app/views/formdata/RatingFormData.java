package views.formdata;

import models.Surfer;

/**
 * Holds the form data for the surfer rating.
 * @author Andrew Pearson-Wood
 */
public class RatingFormData {
  
  /** rating. */
  public int rating;
  
  /**
   * Blank constructor.
   */
  public RatingFormData() {
  }

  /**
   * Constructor.
   * @param surfer the surfer to rate.
   */
  public RatingFormData(Surfer surfer) {
    this.rating = 0;
  }
}
