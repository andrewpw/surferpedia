package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;
import models.Surfer;

public class SurferDB {

  public static Map<String, Surfer> map = new HashMap<>();
  
  public static Surfer add (String slug, SurferFormData surferFD){
    Surfer surfer;
    
    if (!map.containsKey(slug)){
      int index = map.size() + 1;
      surfer = new Surfer(surferFD.name, surferFD.hometown, surferFD.awards, surferFD.carouselURL, surferFD.bio, 
          surferFD.bioURL, surferFD.slug, surferFD.type, index, surferFD.slugIndex);
      map.put(surferFD.slug, surfer);
    }
    else {
      surfer = new Surfer(surferFD.name, surferFD.hometown, surferFD.awards, surferFD.carouselURL, surferFD.bio, 
          surferFD.bioURL, surferFD.slug, surferFD.type, surferFD.index, surferFD.slugIndex);
      map.put(surferFD.slug, surfer);      
    }
    return surfer;
  }

  public static Surfer getSurfer(String slug) {
    if (map.containsKey(slug)){
      return map.get(slug);
    }
    else{
      return null;
    }
  }
  
  public static List<Surfer> getSurferList(){
    List<Surfer> surferList = new ArrayList<>();
    surferList.addAll(map.values());
    return surferList;
  }

  public static void deleteSurfer(String slug) {
    map.remove(slug);
  }
}
