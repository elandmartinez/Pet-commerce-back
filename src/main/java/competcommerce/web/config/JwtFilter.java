package competcommerce.web.config;

import competcommerce.service.UserSecurityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public JwtFilter (JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        //validar que sea un header autorization valido (que el json en el header contenga realmente un jwt)

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Basic") && !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        //validar que el jwt proporcionado sea adecuado para el estandar jwt (que contenga las credencials del usuario para pasar el filtro de seguridad)
        String jwt = authHeader.split(" ")[1].trim();

        if(!this.jwtUtil.isValid(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        //cargar el usuario en UserDetailService (confirmar que el usuario i exista en base de datos y realmente tenga permisos)


        String username = this.jwtUtil.getUsername(jwt);

        User user = (User) userDetailsService.loadUserByUsername(username);

        //cargar al usuario en el contexto de seguridad (darle acceso al usuario en los niveles correspondientes a su rango)

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
        SecurityContextHolder.getContext().setAuthentication(authToken);
        System.out.println(authToken.getPrincipal());
        filterChain.doFilter(request, response);
    }
}
