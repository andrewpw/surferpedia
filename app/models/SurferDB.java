package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;
import views.formdata.SurferFormData;
import models.Surfer;

public class SurferDB {
  
  private static final int PAGE_SIZE = 15;
  
  public static Surfer add(String slug, SurferFormData surferFD){
    
    Surfer surfer;
    if (!doesSurferExist(slug)){
      surfer = new Surfer(surferFD.name, surferFD.hometown, surferFD.awards, surferFD.carouselURL, surferFD.bio, 
          surferFD.bioURL, surferFD.slug, surferFD.type, surferFD.footstyle, surferFD.country);
      SurferUpdate update = new SurferUpdate("Create", surfer.getName());
      SurferUpdateDB.addUpdate(update);
      surfer.save();
    }
    else {
      surfer = getSurfer(slug);
      surfer.setName(surferFD.name);
      surfer.setHometown(surferFD.hometown);
      surfer.setAwards(surferFD.awards);
      surfer.setCarouselURL(surferFD.carouselURL);
      surfer.setBio(surferFD.bio);
      surfer.setBioURL(surferFD.bioURL);
      surfer.setType(surferFD.type);
      surfer.setFootstyle(surferFD.footstyle);
      surfer.setCountry(surferFD.country);
      SurferUpdateDB.addUpdate(new SurferUpdate("Edit", surfer.getName()));
      surfer.save();
    }
    return surfer;
  }
  
  public static List<String> getFootstyleList() {
    String[] footArray = {"Goofy", "Regular"};
    return Arrays.asList(footArray);
  }

  public static Surfer getSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique();
  }
  
  public static List<Surfer> getSurferList(){
    return Surfer.find().all();
  }
  
  public static List<Surfer> getRandomSurferList(){
    List<Surfer> list = getSurferList();
    Collections.shuffle(list);
    return list.subList(0, 3);
  }
  
  /**
   * Check if a Surfer already exists.
   * @param slug Slug of surfer.
   * @return True if the Surfer exists, false otherwise.
   */
  public static boolean doesSurferExist(String slug) {
    return (getSurfer(slug) != null);
  }

  /**
   * Delete  Surfer.
   * @param slug Slug of the Surfer. 
   */
  public static void deleteSurfer(String slug) {
    Surfer surfer = getSurfer(slug);
    SurferUpdateDB.addUpdate(new SurferUpdate("Delete", SurferDB.getSurfer(slug).getName()));
    surfer.delete();
  }
  
  /**
   * Return a list of Surfers that match the given criteria.
   * @param term The search term.
   * @param type The type of surfer.
   * @param country The country of the surfer.
   * @param page Page number to retrieve.
   * @return A List of Surfers that match the search criteria.
   */
  public static Page<Surfer> search(String term, String type, String country, int page) {
    return Surfer.find().where().icontains("name", term).icontains("type", type)
        .icontains("country", country).order("name").findPagingList(PAGE_SIZE).setFetchAhead(false).getPage(page);
  }
}
