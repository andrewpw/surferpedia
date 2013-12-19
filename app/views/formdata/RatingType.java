package views.formdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Options for Rating value.
 */
public class RatingType {
  
    /**
     * Return a List of options for the Rating form.
     * @return A List of Strings.
     */
    public static List<String> getTypes() {
      String [] valueArray = {"No Rating", "1", "2", "3", "4", "5"};
      List<String> values = new ArrayList<>();
      for (String current : valueArray) {
        values.add(current);
      }
      Collections.reverse(values);
      return values;
    }

}
