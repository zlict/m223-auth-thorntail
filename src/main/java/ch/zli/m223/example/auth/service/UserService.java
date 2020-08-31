package ch.zli.m223.example.auth.service;

import ch.zli.m223.example.auth.domain.map.Roles;
import ch.zli.m223.example.auth.domain.model.RoleModel;
import ch.zli.m223.example.auth.domain.model.UserModel;
import ch.zli.m223.example.auth.domain.repository.RoleRepository;
import ch.zli.m223.example.auth.domain.repository.UserRepository;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    RoleRepository roleRepository;

    @Inject
    JWTService jwtService;

    @Inject
    JsonWebToken jsonWebToken;

    public Response createUser(UserModel user) {
        if (userRepository.count() <= 0) {
            Optional<RoleModel> possibleRole = roleRepository.findByName(Roles.ADMINISTRATOR.getName());

            possibleRole.ifPresent(user::addRole);
        }
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Optional<RoleModel> possibleRole = roleRepository.findByName(Roles.USER.getName());

            possibleRole.ifPresent(user::addRole);
        }
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(userRepository.save(user))
                    .header("Authorization", "Bearer " + this.jwtService.generateToken(user))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    public Response indexUsers() {
        return Response.ok(userRepository.findAll()).build();
    }

    public Response updateUser(UserModel user) {
        UserModel persistedUser = userRepository.findById(user.getId());

        if (!jsonWebToken.getSubject().equals(persistedUser.getEmail())
                && !jsonWebToken.getGroups().contains(Roles.Names.ADMINISTRATOR)) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        if (user.getPassword() != null) {
            try {
                persistedUser.setPassword(user.getPassword());
            } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        if (user.getRoles() != null) {
            persistedUser.setRoles(user.getRoles());
        }
        if (user.getForename() != null) {
            persistedUser.setForename(user.getForename());
        }
        if (user.getSurname() != null) {
            persistedUser.setSurname(user.getSurname());
        }
        if (user.getEmail() != null) {
            persistedUser.setEmail(user.getEmail());
        }
        return Response.ok(userRepository.save(persistedUser)).build();
    }

    public Response deleteUser(Long id) {
        UserModel user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
            return Response.ok(user).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
