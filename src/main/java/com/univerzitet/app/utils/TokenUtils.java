package com.univerzitet.app.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.univerzitet.app.model.RegistrovaniKorisnik;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TokenUtils {

    private final SecretKey secretKey;
    private final long tokenValidityMilliseconds = 86400000; // 24 sata

    public TokenUtils(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(UserDetails userDetails, RegistrovaniKorisnik korisnik) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        claims.put("id", korisnik.getId());
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims) 
                .setSubject(userDetails.getUsername()) 
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidityMilliseconds))
                .signWith(secretKey, SignatureAlgorithm.HS256) 
                .compact();
    }
    
    public boolean isTokenValid(String token) {
    	try {
    		Jws<Claims> claimsJws  = Jwts.parserBuilder()
    				.setSigningKey(secretKey)
    				.build()
    				.parseClaimsJws(token);
    		
    		Claims claims = claimsJws.getBody();
    		
    		Date expirationDate = claims.getExpiration();
            return expirationDate != null && expirationDate.after(new Date());

    	} catch(JwtException e) {
    		return false;
    	}
    }
    
    public String getSubjectFromToken(String token) {
    	try {
    		Jws<Claims> claimsJws = Jwts.parserBuilder()
    				.setSigningKey(secretKey)
    				.build()
    				.parseClaimsJws(token);
    		
    		return claimsJws.getBody().getSubject();
    	} catch (JwtException e) {
    		return null;
    	}
    }
}