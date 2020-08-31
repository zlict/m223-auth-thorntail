package ch.zli.m223.example.auth.controller;

import ch.zli.m223.example.auth.domain.map.Roles;
import ch.zli.m223.example.auth.domain.model.UserModel;
import ch.zli.m223.example.auth.service.UserService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@DenyAll
public class UserController {

    @Inject
    UserService userService;

    /**
     * Exposes a list of users.
     *
     * @return a json list of users.
     */
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed(Roles.Names.ADMINISTRATOR)
    public Response index() {
        return userService.indexUsers();
    }

    /**
     * This is the sign up endpoint.
     *
     * @return a response whether a user has been created or not.
     */
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @PermitAll
    public Response create(@Valid UserModel user) {
        return userService.createUser(user);
    }

    /**
     * Updates a given user.
     *
     * @param user to be updated
     * @return an updated user
     */
    @PUT
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed("*")
    public Response update(@Valid UserModel user) {
        return userService.updateUser(user);
    }

    /**
     * Deletes a user
     *
     * @param id of the to be deleted user
     * @return a deleted user
     */
    @DELETE
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @RolesAllowed(Roles.Names.ADMINISTRATOR)
    public Response delete(@PathParam("id") Long id) {
        return userService.deleteUser(id);
    }
}
