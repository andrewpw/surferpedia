package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Update object for Surferpedia.
 */
@Entity
public class SurferUpdate extends Model {
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String date;
  private String type;
  private String target;

  /**
   * Constructor.
   * @param updateType Type of update.
   * @param surferName Name of surfer.
   */
  public SurferUpdate(String updateType, String surferName) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    this.date = dateFormat.format(date);
    this.type = updateType;
    this.target = surferName;
  }

  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }

  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * @param target the target to set
   */
  public void setTarget(String target) {
    this.target = target;
  }
  
  /**
   * The EBean ORM finder method for database queries on Update.
   * @return The finder method for Update
   */
  public static Finder<Long, SurferUpdate> find() {
    return new Finder<Long, SurferUpdate>(Long.class, SurferUpdate.class);
  }
  
}
