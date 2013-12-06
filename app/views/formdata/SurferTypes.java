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
  public SurferTypes(){
  }
  
  public SurferTypes(Surfer surfer){
    genderMap.put(surfer.getType(), true);
  }
  
  /**
   * returns a map of all acceptable telephone types and a boolean to tell if they are selected
   * @return telMap the telephone map
   */
  public static Map<String, Boolean> getTypes(){
    return genderMap;
  }
  
  /**
   * returns a map of all acceptable telephone types and a boolean to tell if they are selected
   * @param telType the type of telephone to be added
   * @return telMap the telephone map
   */
  public static Map<String, Boolean> getTypes(String type){
    genderMap.put(type, true);
    return genderMap;
  }
  
  /**
   * returns boolean indicating if the provided telephone type is legal.
   * @return isLegal a boolean to indicate if the telephone type is legal
   */
  public static Boolean isTypes(String type){
    return genderMap.containsKey(type);
  }
}
