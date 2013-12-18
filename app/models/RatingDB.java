package models;

import com.avaje.ebean.Ebean;

public class RatingDB {
  
  /**
   * Set a Rating.
   * @param rating the Rating to set.
   */
  public static void addRating(Surfer surfer, UserInfo userInfo, int ratingVal) {
    if(userInfo != null || ratingVal == 100){
      Rating rating = Rating.find().where().eq("surfer_id", surfer.getId()).findUnique();
      if(rating == null){
        rating = new Rating(surfer, userInfo);
        rating.setRating(ratingVal, userInfo);
        Ebean.save(rating);
        surfer.update();
      }
      else{
        if (!hasRated(surfer, userInfo)){
          System.out.println("ratingDB else" + rating.getRating());
            rating.setRating(ratingVal, userInfo);
            Ebean.update(rating);
            //rating.update();
        }
      }
    }
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
