package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import play.db.ebean.Model;

/**
 * A Surfer Object.
 */
@Entity
public class Surfer extends Model {
  private static final long serialVersionUID = 1L;
  private static final int MAX_BIO_LENGTH = 40;
  @Id
  private long id;
  private String name;
  private String hometown;
  private String awards;
  private String carouselURL;
  private String bioURL;
  @Lob
  private String bio;
  private String slug;
  private String type;
  private boolean slugDefined = false;
  private String footstyle;
  private String country;
  
  @OneToMany(mappedBy = "surfer")
  private List<Favorite> favorites = new ArrayList<>();
  @OneToMany(mappedBy = "surfer")
  private List<Rating> ratings = new ArrayList<>();
  
  /**
   * A Surfer Constructor.
   * @param name The name of the Surfer.
   * @param hometown The hometown of the Surfer.
   * @param awards Awards the Surfer has won.
   * @param carouselURL The URL for the Surfer's carousel image.
   * @param bio The biography of the Surfer.
   * @param bioURL The URL to the image used on the Surfer's personal page.
   * @param slug The slug of the Surfer.
   * @param type The type of Surfer.
   * @param footstyle The Footstyle of the Surfer.
   * @param country The country of origin of the Surfer.
   */
  public Surfer(String name, String hometown, String awards, String carouselURL, String bio, String bioURL, 
      String slug, String type, String footstyle, String country) {
    this.name = name;
    this.hometown = hometown;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.footstyle = footstyle;
    this.country = country;
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
  * @return The footstyle.
  */
  public String getFootstyle() {
    return footstyle;
  }

  /**
   * @param footstyle the footstyle to set.
   */
  public void setFootstyle(String footstyle) {
    this.footstyle = footstyle;
  }

  /**
   * @return the bio.
   */
  public String getBio() {
    return bio;
  }

  /**
   * @param bio the bio to set.
   */
  public void setBio(String bio) {
    this.bio = bio;
  }
  
  /**
   * @return the name.
   */
  public String getName() {
    return name;
  }
  
  /**
   * @param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * @return the hometown.
   */
  public String getHometown() {
    return hometown;
  }
  
  /**
   * @param hometown the hometown to set.
   */
  public void setHometown(String hometown) {
    this.hometown = hometown;
  }
  
  /**
   * @return the rewards.
   */
  public String getAwards() {
    return awards;
  }
  
  /**
   * @param awards the awards to set.
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }
  
  /**
   * @return the caruosel URL.
   */
  public String getCarouselURL() {
    return carouselURL;
  }
  
  /**
   * @param carouselURL the carouselURL to set.
   */
  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }
  
  /**
   * @return the bio URL.
   */
  public String getBioURL() {
    return bioURL;
  }
  
  /**
   * @param bioURL the bioURL to set.
   */
  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }
  
  /**
   * @return the type.
   */
  public String getType() {
    return type;
  }
  
  /**
   * @param type the type to set.
   */
  public void setType(String type) {
    this.type = type;
  }
  
  /**
   * @return the slug.
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @return the slug defined.
   */
  public boolean getSlugIndex() {
    return slugDefined;
  }
  
  /**
  
  /**
   * @param value Value to set.
   */
  public void setSlugDefined(boolean value) {
    this.slugDefined = value;
  }
  
  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }
  
  /**
   * @return the favorites
   */
  public List<Favorite> getFavorites() {
    return favorites;
  }
  
  /**
   * Add a favorite.
   * @param favorite Favorite to add.
   */
  public void addFavorite(Favorite favorite) {
    if (favorite != null) {
      favorites.add(favorite);
    }
  }
  
  /**
   * Add a Rating.
   * @param rating the Rating to add.
   */
  public void addRating(Rating rating) {
    ratings.add(rating);
  }
  
  /**
   * @return the rating.
   */
  public List<Rating> getRatings() {
      return ratings;
  }
  
  /**
   * Get a truncated (40 characters max) biography of a Surfer.
   * @return A truncated biography of the Surfer.
   */
  public String getTruncatedBio() {
    if (this.bio.length() <= MAX_BIO_LENGTH) {
      return this.bio;
    }
    else {
      return this.bio.substring(0, MAX_BIO_LENGTH);
    }
  }
  
  /**
   * Get Surfer's average numerical rating.
   * @return An average rating for the Surfer.
   */
  public double getAverageRating() {
    double average = 0.0;
    for (Rating rating : ratings) {
      average += rating.getRating();
    }
    return average / ratings.size();
  }
 
  /**
   * The EBean ORM finder method for database queries on ID.
   * @return The finder method for products.
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
}
