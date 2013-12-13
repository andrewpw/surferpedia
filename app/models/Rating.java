package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

@Entity
public class Rating extends Model {
  private static final long serialVersionUID = 1L;
  
  @Id
  private static long id;
  private static long rating;
  
  @ManyToOne
  private UserInfo userInfo;
  @ManyToOne
  private Surfer surfer;
  
  /**
   * @return the rating
   */
  public static long getRating() {
    return rating;
  }
  /**
   * @param rating the rating to set
   */
  public static void setRating(long rating) {
    Rating.rating = rating;
  }
  
  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }
  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  /**
   * @return the surfer
   */
  public Surfer getSurfer() {
    return surfer;
  }
  /**
   * @param surfer the surfer to set
   */
  public void setSurfer(Surfer surfer) {
    this.surfer = surfer;
  }
  
  /**
   * The EBean ORM finder method for database queries on ID.
   * @return The finder method for Ratings.
   */
  public static Finder<Long, Rating> find() {
    return new Finder<Long, Rating>(Long.class, Rating.class);
  }

}
