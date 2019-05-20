/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Project: Marathon
 * Autor: Myriam Schaffter
 * Date: 23.11.17 10:45
 * Module: sa17-projet1
 */

package ch.hearc.ig.odi.service;

import ch.hearc.ig.odi.business.Marathon;
import ch.hearc.ig.odi.exception.MarathonException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock persistence service class. Used as singleton to simulate persistence
 */
public class RestService {

  private final DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
  private Map<Long, Marathon> mapMarathon;

  /**
   * Empty constructor. All initialization should be done here.
   */
  public RestService() throws ParseException {

    populateMockPersistenceData();

  }


  /**
   * Allows to check that the same RestService is used for all requests.
   *
   * @return this object's HashCode
   */
  public int getHashCode() {
    return hashCode();
  }

  public Date getDate(String date) throws ParseException {
    return format.parse(date);
  }

  public List<Marathon> getMarathons() {
    List<Marathon> marathons = new ArrayList<>(mapMarathon.values());
    return marathons;
  }

  public Marathon getMarathon(Long id) {
    return mapMarathon.get(id);
  }

  public Marathon updateMarathon(Long id, String name, String city) {
    Marathon m = mapMarathon.get(id);
    m.setName(name);
    m.setCity(city);
    return mapMarathon.get(id);
  }


  public Marathon createMarathon(Long id, String name, String city) throws MarathonException {
    if (id != null) {
      mapMarathon.put(id, new Marathon(id, name, city));
      return mapMarathon.get(id);
    } else {
      throw new MarathonException("id Marathon can't be null");
    }
  }

  public void deleteMarathon(Long id) throws MarathonException {
    Marathon m = mapMarathon.remove(id);
    if (m == null) {
      throw new MarathonException("Marathon doesn't exist");
    }
  }

  private void populateMockPersistenceData() throws ParseException {
    mapMarathon = new HashMap<>();

    //create marathon
    Marathon m0 = new Marathon(Long.parseLong("1000"), "Swiss Alpine Marathon", "Davos");
    Marathon m1 = new Marathon(Long.parseLong("1001"), "Lausanne Marathon", "Lausanne");
    Marathon m2 = new Marathon(Long.parseLong("1002"), "Bieler Lauftage", "Bienne");
    Marathon m3 = new Marathon(Long.parseLong("1003"), "Geneva Marathon", "Genève");

    //add marathon to list of marathons
    mapMarathon.put(m0.getId(), m0);
    mapMarathon.put(m1.getId(), m1);
    mapMarathon.put(m2.getId(), m2);
    mapMarathon.put(m3.getId(), m3);
  }

}
