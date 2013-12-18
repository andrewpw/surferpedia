package models;

/**
 * A database of Ratings.
 */
public class RatingDB {
  
  /**
   * Add a Rating.
   * @param surfer a surfer to add a rating too
   * @param userInfo the user adding the rating
   * @param ratingVal the Rating to set.
   */
  public static void addRating(Surfer surfer, UserInfo userInfo, int ratingVal) {
    if (surfer != null && userInfo != null && !hasRated(surfer, userInfo)) {
      Rating rating = new Rating(surfer, userInfo, ratingVal);
      rating.save();
    }
  }
  
  /**
   * Get a Rating.
   * @param surfer A Surfer.
   * @param userInfo An UserInfo.
   * @return The Rating object corresponding between a Surfer and an UserInfo, otherwise null.
   */
  public static Rating getRating(Surfer surfer, UserInfo userInfo) {
    return Rating.find().where().eq("surfer", surfer).eq("userInfo", userInfo).findUnique();
  }
  
  /**
   * Check if a User has already rated a surfer.
   * @param surfer A Surfer.
   * @param userInfo the userInfo of the current user.
   * @return True if a Rating object exists, false otherwise.
   */
  public static boolean hasRated(Surfer surfer, UserInfo userInfo) {
    return Rating.find().where().eq("surfer", surfer).eq("userInfo", userInfo).findUnique() != null;
  }
}
