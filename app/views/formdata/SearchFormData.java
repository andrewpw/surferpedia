package views.formdata;

/**
 * Holds the form data for searches.
 * @author eduardgamiao
 */
public class SearchFormData {
  
  /** Search term. */
  public String searchTerm = "";
  
  /** Surfer type. */
  public String type;
  
  /** Country. */
  public String country;
  
  /**
   * Blank constructor.
   */
  public SearchFormData() {
  }

  /**
   * Constructor.
   * @param searchTerm The search term.
   * @param type The Surfer type.
   * @param country The country type.
   */
  public SearchFormData(String searchTerm, String type, String country) {
    this.searchTerm = searchTerm;
    this.type = type;
    this.country = country;
  }
}
