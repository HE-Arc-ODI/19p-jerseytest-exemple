/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Project: Marathon
 * Autor: Myriam Schaffter
 * Date: 17.11.17 12:02
 * Module: sa17-projet1
 */

package ch.hearc.ig.odi.business;

import java.io.Serializable;

public class Marathon implements Serializable {

  private Long id;
  private String name;
  private String city;

  public Marathon() {
  }

  public Marathon(Long id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
