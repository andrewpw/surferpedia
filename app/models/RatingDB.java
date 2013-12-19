package models;

import com.avaje.ebean.Ebean;

/**
 * A class for accessing the mySQL database and storing surfer ratings.
 * @author Andrew
 *
 */
public class RatingDB {
  
  /**
   * Set a Rating.
   * @param surfer a surfer to add a rating too
   * @param userInfo the user adding the rating
   * @param ratingVal the Rating to set.
   */
  public static void addRating(Surfer surfer, UserInfo userInfo, int ratingVal) {
    if (userInfo != null) {
      Rating rating = Rating.find().where().eq("surfer_id", surfer.getId()).findUnique();
      if (rating == null) {
        rating = new Rating(surfer, userInfo);
        rating.setRating(ratingVal, userInfo);
        Ebean.save(rating);
        surfer.update();
      }
      else {
        if (!hasRated(surfer, userInfo)) {
          System.out.println("ratingDB else" + rating.getRating());
            rating.setRating(ratingVal, userInfo);
            Ebean.update(rating);
            //rating.update();
        }
      }
    }
  }
  
  /**
   * Deletes the users previous rating of a surfer by re-adjusting the average.
   * @param surfer the surfer who's rating is being modified
   * @param userInfo the user info who's rating is being deleted
   */
  public static void deleteUserRating(Surfer surfer, UserInfo userInfo) {
    Rating rating = Rating.find().where().eq("surfer_id", surfer.getId()).findUnique();
    System.out.println("old rating " + rating.getRating());
    rating.deleteUserRating(userInfo);
    if (rating.getRating() != 0) {
      Ebean.save(rating);
    }
    else {
      Ebean.delete(rating);
    }
    surfer.update();
    System.out.println("new rating " + rating.getRating());
  }
  
  /**
   * gets the rating the user gave to the specified surfer.
   * @param surfer the surfer who's rating is being gotten
   * @param userInfo the user who's rating association we are looking for
   * @return the rating the user gave to the surfer
   */
  public static int getUserRating(Surfer surfer, UserInfo userInfo) {
    Rating rating = Rating.find().where().eq("surfer_id", surfer.getId()).findUnique();
    return rating.getUserRating(userInfo);
  }
  
  /**
   * deletes a rating altogether.
   * @param rating the rating to delete
   */
  public static void deleteRating(Rating rating) {
    Ebean.delete(rating);
  }
  
  /**
   * Check if a User has already rated a surfer.
   * @param surfer A Surfer.
   * @param userInfo the userInfo of the current user.
   * @return True if a Rating object exists, false otherwise.
   */
  public static boolean hasRated(Surfer surfer, UserInfo userInfo) {
    Rating rating = Rating.find().where().eq("surfer", surfer).findUnique();
    return (rating.getUserInfos().contains(userInfo));
  }
}
