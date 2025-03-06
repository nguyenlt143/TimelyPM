package dev.fpt.web_app.application.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


public interface JwtService {

    String extractUsername(String token);

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver);

    Claims extractAllClaims(String token);

    Key getSignInKey();

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public String generateToken(UserDetails userDetails);

    public boolean validateToken(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);
}
