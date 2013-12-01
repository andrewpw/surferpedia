package models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Surfer {

  private String name;
  private String hometown;
  private String awards;
  private String carouselURL;
  private String bioURL;
  private String bio;
  private String slug;
  private String type;
  private boolean slugDefined = false;
  private String footstyle;
  
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
  
  
}
