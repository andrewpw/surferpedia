package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A database of Update objects.
 */
public class UpdateDB {

  private static List<Update> updates = new ArrayList<Update>();
  
  /**
   * Return a list of updates.
   * @return A list of updates.
   */
  public static List<Update> getUpdates() {
    return updates;
  }
  
  /**
   * Add an update to the database.
   * @param update Update to be added.
   */
  public static void addUpdate(Update update) {
    updates.add(update);
  }
}
