package ma.enset.controlebackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import ma.enset.controlebackend.entities.AppUser;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private final String secret = "my-secret-key";
    private final long expiration = 1000 * 60 * 60;

    public String generateToken(AppUser user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("roles", user.getRoles()
                        .stream()
                        .map(role -> role.getRoleName())
                        .collect(Collectors.toList()))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(algorithm);
    }

    public String validateTokenAndGetUsername(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }
}