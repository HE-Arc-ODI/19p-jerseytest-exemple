package ch.hearc.ig.odi.rest.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class AuthenticationEndpointTest extends JerseyTest {

  @Test
  public void authenticateKnownUserSucceeds() {
    // Arrange
    String username = "bob";
    String password = "1234";
    int expectedStatus = 200;


    // Act
    MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
    formData.add("username", username);
    formData.add("password", password);
    final Response response = target("authentication").request().post(Entity.form(formData));

    //Assert
    assertEquals(expectedStatus, response.getStatus());
  }

  @Override
  protected Application configure() {
    return new ResourceConfig() {
      {
        register(AuthenticationEndpoint.class);
      }
    };
  }
}