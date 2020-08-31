package ch.zli.m223.example.auth.controller;

import ch.zli.m223.example.auth.domain.form.Credentials;
import ch.zli.m223.example.auth.service.SessionService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/session")
@DenyAll
public class SessionController {

    @Inject
    SessionService sessionService;

    /**
     * This is the sign in endpoint.
     *
     * @return a response whether a login was successful or not.
     */
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @PermitAll
    public Response create(@Valid Credentials credentials) {
        return this.sessionService.authenticate(credentials);
    }
}
