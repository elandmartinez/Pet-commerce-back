package competcommerce.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "pet-commerce";
    private static final Algorithm ALGORTITHM = Algorithm.HMAC256(SECRET_KEY);

    public String create (String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("pet-commerce")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORTITHM);
    }

    public boolean isValid (String jwt) {
        try {
            JWT.require(ALGORTITHM)
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
    public String getUsername (String jwt) {
        return JWT.require(ALGORTITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}
