package ch.zli.m223.example.auth.service;

import ch.zli.m223.example.auth.Settings;
import ch.zli.m223.example.auth.domain.model.RoleModel;
import ch.zli.m223.example.auth.domain.model.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class JWTService {
    /**
     * Generates a new JWT based on a given user.
     *
     * @param user for which a JWT should be issued.
     * @return a JWT as string
     */
    public String generateToken(UserModel user) {
        DefaultClaims claims = new DefaultClaims();
        claims.setSubject(user.getEmail());
        claims.setId(user.getId().toString());
        claims.put("groups", user.getRoles().stream().map(RoleModel::getName).toArray());

        return generateTokenFromClaims(claims);
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + Settings.TOKEN_EXPIRATION_TIME);
    }

    private String generateTokenFromClaims(Claims claims) {
        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(generateExpirationDate())
                    .setIssuer(Settings.TOKEN_ISSUER)
                    .signWith(SignatureAlgorithm.RS256, Settings.getPrivateKey()).compact();
        } catch (Exception e) {
            return "";
        }
    }
}
