package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

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
  private int rating;
  
  @OneToMany(mappedBy = "surfer")
  private List<SurferUpdate> surferUpdates = new ArrayList<>();
  
  @OneToMany(mappedBy = "surfer")
  private List<Favorite> favorites = new ArrayList<>();
  
  public Surfer (String name, String hometown, String awards, String carouselURL, String bio, String bioURL, 
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
    this.rating = 0;
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
   * @return the rating
   */
  public int getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getFootstyle() {
    return footstyle;
  }

  public void setFootstyle(String footstyle) {
    this.footstyle = footstyle;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getHometown() {
    return hometown;
  }
  public void setHometown(String hometown) {
    this.hometown = hometown;
  }
  public String getAwards() {
    return awards;
  }
  public void setAwards(String awards) {
    this.awards = awards;
  }
  public String getCarouselURL() {
    return carouselURL;
  }
  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }
  public String getBioURL() {
    return bioURL;
  }
  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getSlug() {
    return slug;
  }

  public boolean getSlugIndex() {
    return slugDefined;
  }
  
  /**
   * Get list of Surfer Updates tied to this Surfer.
   * @return A list of Surfer Updates.
   */
  public List<SurferUpdate> getSurferUpdates() {
    return surferUpdates;
  }
  
  /**
   * Add Surfer Update.
   * @param update Surfer Update to add.
   */
  public void addSurferUpdates(SurferUpdate update) {
    surferUpdates.add(update);
  }
  
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
   * The EBean ORM finder method for database queries on ID.
   * @return The finder method for products.
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
}
