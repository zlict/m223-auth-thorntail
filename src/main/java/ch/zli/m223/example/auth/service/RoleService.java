package ch.zli.m223.example.auth.service;

import ch.zli.m223.example.auth.domain.repository.RoleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RoleService {

    @Inject
    RoleRepository roleRepository;

    public Response indexRoles() {
        return Response.ok(roleRepository.findAll()).build();
    }
}
