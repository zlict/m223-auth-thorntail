package ch.zli.m223.example.auth.service;

import ch.zli.m223.example.auth.domain.form.Credentials;
import ch.zli.m223.example.auth.domain.model.UserModel;
import ch.zli.m223.example.auth.domain.repository.UserRepository;
import ch.zli.m223.example.auth.util.PBKDF2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class SessionService {

    @Inject
    JWTService jwtService;

    @Inject
    UserRepository userRepository;

    public Response authenticate(Credentials credentials) {
        Optional<UserModel> principal = userRepository.findByEmail(credentials.getEmail());

        try {
            if (principal.isPresent() && PBKDF2.validate(credentials.getPassword(), principal.get().getPassword())) {
                return Response
                        .ok(principal.get())
                        .header("Authorization", "Bearer " + this.jwtService.generateToken(principal.get()))
                        .build();
            }
        } catch(Exception e) {
            System.err.println("Couldn't validate password.");
        }

        return Response.status(Response.Status.FORBIDDEN).build();
    }
}
