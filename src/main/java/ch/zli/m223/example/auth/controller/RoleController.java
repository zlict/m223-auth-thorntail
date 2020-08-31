package ch.zli.m223.example.auth.controller;

import ch.zli.m223.example.auth.domain.map.Roles;
import ch.zli.m223.example.auth.service.RoleService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/roles")
@DenyAll
public class RoleController {

    @Inject
    RoleService roleService;

    /**
     * Exposes a list of roles.
     *
     * @return all roles
     */
    @GET
    @RolesAllowed(Roles.Names.ADMINISTRATOR)
    public Response index() {
        return roleService.indexRoles();
    }
}
