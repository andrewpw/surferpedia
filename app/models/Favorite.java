package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * A representation of a User adding a Surfer as a favorite.
 */
@Entity
public class Favorite extends Model {
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  @ManyToOne
  private Surfer surfer;
  @ManyToOne
  private UserInfo userInfo;
  
  /**
   * Constructor.
   * @param surfer A Surfer.
   * @param userInfo An UserInfo.
   */
  public Favorite(Surfer surfer, UserInfo userInfo) {
    this.surfer = surfer;
    this.userInfo = userInfo;
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
  public static Finder<Long, Favorite> find() {
    return new Finder<Long, Favorite>(Long.class, Favorite.class);
  }

}
