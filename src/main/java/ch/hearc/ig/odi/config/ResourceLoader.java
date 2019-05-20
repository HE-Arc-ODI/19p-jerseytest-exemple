package ch.hearc.ig.odi.config;

import ch.hearc.ig.odi.filter.AuthenticationFilter;
import ch.hearc.ig.odi.injection.ServiceBinder;
import ch.hearc.ig.odi.injection.ServiceFeature;
import ch.hearc.ig.odi.rest.resources.AuthenticationEndpoint;
import ch.hearc.ig.odi.rest.resources.MarathonRest;
import ch.hearc.ig.odi.service.RestService;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers all resources with Jersey
 */
public class ResourceLoader extends ResourceConfig {

  public ResourceLoader() {
    register(MarathonRest.class);
    register(AuthenticationEndpoint.class);
    register(AuthenticationFilter.class);
    register(RestService.class);
    register(ServiceFeature.class);
    registerInstances(new ServiceBinder());
  }

}

