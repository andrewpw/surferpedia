package models;

import java.util.List;

/**
 * A database of Update objects.
 */
public class SurferUpdateDB {  
  /**
   * Return a list of updates.
   * @return A list of updates.
   */
  public static List<SurferUpdate> getUpdates() {
    return SurferUpdate.find().all();
  }
  
  /**
   * Add an update to the database.
   * @param update Update to be added.
   */
  public static void addUpdate(SurferUpdate update) {
    update.save();
  }
}
