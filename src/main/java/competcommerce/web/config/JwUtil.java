package competcommerce.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwUtil {
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
}
