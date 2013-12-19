package views.formdata;
import java.util.LinkedHashMap;
import java.util.Map;
import models.Surfer;

/**
 * 
 * Holds the telephone type data for the drop down list.
 * @author Andrew
 *
 */
public class SurferTypes {

  private static Map<String, Boolean> genderMap = new LinkedHashMap<>();
  static {
    genderMap.put("Male", false);
    genderMap.put("Female", false);
    genderMap.put("Grom", false);
  }
  /**
   * 
   * No arguments constructor.
   */
  public SurferTypes() {
  }
  
  /**
   * adds a type to a surfer.
   * @param surfer the surfer to add
   */
  public SurferTypes(Surfer surfer) {
    genderMap.put(surfer.getType(), true);
  }
  
  /**
   * returns a map of all gender types.
   * @return genderMap the map of the genderst
   */
  public static Map<String, Boolean> getTypes() {
    return genderMap;
  }
  
  /**
   * gets the specific type wanted.
   * @param type the type wanted.
   * @return genderMap the map of all genders
   */
  public static Map<String, Boolean> getTypes(String type) {
    genderMap.put(type, true);
    return genderMap;
  }
  
  /**
   * returns boolean indicating if the provided type is legal.
   * @param type the type to check
   * @return a boolean to indicate if the type is legal
   */
  public static Boolean isTypes(String type) {
    return genderMap.containsKey(type);
  }
}
