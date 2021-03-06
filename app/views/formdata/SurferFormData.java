package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * Holds the data when a New Contact form is filled in.
 */
public class SurferFormData {
  
  private static final int MIN_URL_SIZE = 5;
  private static final int EXTENSION = 4;
  
  /** Surfer name.*/
  public String name = "";
  
  /** Surfer hometown. */
  public String hometown = "";
  
  /** Surfer awards. */
  public String awards = "";
  
  /** URL for carousel image. */
  public String carouselURL;
  
  /** URL for bio image. */
  public String bioURL;
  
  /** Biography. */
  public String bio;
  
  /** Surfer slug. */
  public String slug;
  
  /** Surfer type. */
  public String type;
  
  /** Specified is slug is already defined. */
  public boolean slugDefined;
  
  /** Surfer country. */
  public String country;
  
  /** Surfing style of Surfer. */
  public String footstyle;
  
  /**
   * No argument constructor for this class.
   */
  public SurferFormData() { 
  }
  
  /**
   * Constructor that takes a contact.
   * @param surfer The Surfer to add.
   */
  public SurferFormData(Surfer surfer) {
    this.name = surfer.getName();
    this.hometown = surfer.getHometown();
    this.awards = surfer.getAwards();
    this.carouselURL = surfer.getCarouselURL();
    this.bioURL = surfer.getBioURL();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
    this.slugDefined = surfer.getSlugIndex();
    this.footstyle = surfer.getFootstyle();
    this.country = surfer.getCountry();
  }
  
  /**
   * Checks to make sure that all form fields are filled.
   * @return null on success.
   *         List<Validation Error> of errors on failure.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (hometown == null || hometown.length() == 0) {
      errors.add(new ValidationError("hometown", "Hometown is required."));
    }
    
    if (carouselURL == null || carouselURL.length() < MIN_URL_SIZE) {
      errors.add(new ValidationError("carouselURL", "Carousel URL is required and must end with an extension."));
    }
    else if ((!carouselURL.substring(carouselURL.length() - EXTENSION).equals(".jpg")) 
                && (!carouselURL.substring(carouselURL.length() - EXTENSION).equals(".png")) 
                  && (!carouselURL.substring(carouselURL.length() - EXTENSION).equals(".gif"))) {
      errors.add(new ValidationError("carouselURL", "Carousel URL must end with .jpg, .png, or .gif"));
    }
    if (bioURL == null || bioURL.length() < MIN_URL_SIZE) {
      errors.add(new ValidationError("bioURL", "Bio image URL is required and must end with an extension."));
    }
    else if ((!bioURL.substring(bioURL.length() - EXTENSION).equals(".jpg")) 
                && (!bioURL.substring(bioURL.length() - EXTENSION).equals(".png")) 
                  && (!bioURL.substring(bioURL.length() - EXTENSION).equals(".gif"))) {
      errors.add(new ValidationError("bioURL", "Bio image URL must end with .jpg, .png, or .gif"));
    }
    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "A one paragraph bio is required."));
    }
    if (!slugDefined && SurferDB.getSurfer(slug) != null) {
      errors.add(new ValidationError("slug", "The slug \"" + slug + "\" is already taken."));      
    }
    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required."));
    } 
    if (type == null || type.length() == 0 || !SurferTypes.isTypes(type)) {
      errors.add(new ValidationError("type", "Type is required."));
    }
    if (country == null || country.length() == 0) {
      errors.add(new ValidationError("country", "Country is required."));
    }
    if (!CountryType.isType(country)) {
      errors.add(new ValidationError("country", "Country does not exist or is not spelled correctly. "
          + "<a href=\"about:blank\">Test</a>"));
    }
    
    
    return errors.isEmpty() ? null : errors;
  }
}
