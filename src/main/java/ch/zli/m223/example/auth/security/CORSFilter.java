package ch.zli.m223.example.auth.security;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Adapted from https://github.com/thorntail/thorntail-examples/blob/master/jaxrs/swagger/src/main/java/org/wildfly/swarm/examples/jaxrs/swagger/CORSFilter.java
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        containerResponseContext.getHeaders().add("Access-Control-Expose-Headers", "Authorization");
        containerResponseContext.getHeaders().add("Access-Control-Max-Age", "-1");
        containerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");
    }
}
