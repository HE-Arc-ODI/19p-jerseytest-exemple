/*
 * Company : HEG-ARC
 * Lesson: ODI SA17
 * Project: Marathon
 * Autor: Myriam Schaffter
 * Date: 23.11.17 10:51
 * Module: sa17-projet1
 */

package ch.hearc.ig.odi.rest.resources;

import ch.hearc.ig.odi.business.Marathon;
import ch.hearc.ig.odi.exception.MarathonException;
import ch.hearc.ig.odi.filter.Secured;
import ch.hearc.ig.odi.service.RestService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("marathon")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class MarathonRest {

  @Inject
  private RestService service;

  @GET
  public List<Marathon> getMarathons() {
    return service.getMarathons();
  }

  @Path("{id}")
  @GET
  public Marathon getMarathon(@PathParam("id") Long id) {
    return service.getMarathon(id);
  }

  @Path("{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public Marathon updateMarathon(@PathParam("id") Long id, Marathon updatedMarathon) {
    return service.updateMarathon(id, updatedMarathon.getName(), updatedMarathon.getCity());
  }

  @POST
  @Secured
  public Marathon createMarathon(@FormParam("id") Long id, @FormParam("name") String name, // FIXME: remove ID from form params!
      @FormParam("city") String city) {
    try {
      return service.createMarathon(id, name, city);
    } catch (MarathonException e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }

  @Path("{id}")
  @DELETE
  public void deleteMarathon(@PathParam("id") Long id) {
    try {
      service.deleteMarathon(id);
    } catch (MarathonException e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
  }
}
