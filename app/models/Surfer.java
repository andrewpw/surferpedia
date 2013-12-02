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
  
  @OneToMany(mappedBy = "surfer")
  private List<SurferUpdate> surferUpdates = new ArrayList<>();
  
  public Surfer (String name, String hometown, String awards, String carouselURL, String bio, String bioURL, 
      String slug, String type, String footstyle) {
    this.name = name;
    this.hometown = hometown;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.footstyle = footstyle;
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
   * @param value Value to set.
   */
  public void setSlugDefined(boolean value) {
    this.slugDefined = value;
  }
  
  /**
   * The EBean ORM finder method for database queries on ID.
   * @return The finder method for products.
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
}
