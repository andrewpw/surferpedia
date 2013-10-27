package models;

public class Surfer {

  private String name;
  private String hometown;
  private String awards;
  private String carouselURL;
  private String bioURL;
  private String bio;
  private String slug;
  private String type;
  private int index;
  private int slugIndex;
  
  public Surfer (String name, String hometown, String awards, String carouselURL, String bio, String bioURL, 
      String slug, String type, int index, int slugIndex) {
    this.name = name;
    this.hometown = hometown;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.index = index;
    this.slugIndex = slugIndex;
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
  public int getIndex() {
    return index;
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

  public int getSlugIndex() {
    return slugIndex;
  }
  
  
}
