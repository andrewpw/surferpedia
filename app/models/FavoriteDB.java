package models;

import java.util.List;

/**
 * A database of Favorites.
 */
public class FavoriteDB {
  
  /**
   * Add a Favorite to the database.
   * @param surfer The Surfer that is becoming a Favorite.
   * @param userInfo The UserInfo making a Favorite.
   */
  public static void add(Surfer surfer, UserInfo userInfo) {
    if (surfer != null && userInfo != null) {
      Favorite favorite = new Favorite(surfer, userInfo);
      favorite.save();
    }
  }
  
  /**
   * Delete a Favorite from the database.
   * @param id The ID of the Favorite to delete.
   */
  public static void delete(long id) {
    Favorite favorite = getFavorite(id);
    if (favorite != null) {
      favorite.delete();
    }
  }

  /**
   * Delete a Favorite from the database.
   * @param surfer A Surfer.
   * @param userInfo An UserInfo.
   */
  public static void delete(Surfer surfer, UserInfo userInfo) {
    Favorite favorite = getFavorite(getIDOfFavorite(surfer, userInfo));
    if (favorite != null) {
      favorite.delete();
    }
  }
  
  /**
   * Retrieve a Favorite based on ID.
   * @param id The ID of the Favorite.
   * @return The Favorite matching the ID, else null.
   */
  public static Favorite getFavorite(long id) {
   return Favorite.find().byId(id);
  }
  
  /**
   * Retrieve a Favorite based on ID.
   * @param surfer A Surfer.
   * @return The Favorite matching the ID, else null.
   */
  public static List<Favorite> getFavorite(Surfer surfer) {
   return Favorite.find().where().eq("surfer", surfer).findList();
  }
  
  /**
   * Retrieve a Favorite based on ID.
   * @param userInfo An UserInfo.
   * @return The Favorite matching the ID, else null.
   */
  public static List<Favorite> getFavorite(UserInfo userInfo) {
   return Favorite.find().where().eq("userInfo", userInfo).findList();
  }
  
  /**
   * Get a Favorite from the database.
   * @param surfer A Surfer.
   * @param userInfo An UserInfo.
   * @return The Favorite object if it exists, null otherwise.
   */
  public static Favorite getFavorite(Surfer surfer, UserInfo userInfo) {
    return Favorite.find().where().eq("surfer", surfer).eq("userInfo", userInfo).findUnique();    
  }
  
  /**
   * Return the ID of the corresponding Favorite object.
   * @param surfer A Surfer.
   * @param userInfo An UserInfo.
   * @return The ID of the corresponding Favorite object, otherwise null.
   */
  public static long getIDOfFavorite(Surfer surfer, UserInfo userInfo) {
    return getFavorite(surfer, userInfo).getId();
  }
  
  /**
   * Check if a Favorite is already made between a Surfer and an UserInfo.
   * @param surfer A Surfer.
   * @param userInfo An Surfer.
   * @return True if a Favorite object exists, false otherwise.
   */
  public static boolean isAFavorite(Surfer surfer, UserInfo userInfo) {
    return Favorite.find().where().eq("surfer", surfer).eq("userInfo", userInfo).findUnique() != null;
  }

}
