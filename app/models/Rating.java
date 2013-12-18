package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * Rating object between a Surfer and an UserInfo.
 */
@Entity
public class Rating extends Model {
    private static final long serialVersionUID = 1L;
    
    @Id
    private long id;
    private int rating = 0;
    
    @ManyToOne
    private Surfer surfer;
    @ManyToOne
    private UserInfo userInfo;
    
    /**
     * Constructor.
     * @param surfer The Surfer.
     * @param userInfo The UserInfo.
     * @param rating The rating.
     */
    public Rating(Surfer surfer, UserInfo userInfo, Integer rating) {
      this.surfer = surfer;
      this.userInfo = userInfo;
      this.rating = rating;
    }
    
    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
      this.rating = rating;
    }
    
    /**
     * @return the rating
     */
    public int getRating() {
      return rating;
    }
    
    /**
     * @return the id
     */
    public long getId() {
      return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
      this.id = id;
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
     * The EBean ORM finder method for database queries on ID.
     * @return The finder method for Favorites.
     */
    public static Finder<Long, Rating> find() {
      return new Finder<Long, Rating>(Long.class, Rating.class);
    }
}
