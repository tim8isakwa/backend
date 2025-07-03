package com.univerzitet.app.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private AuthenticationFilterBean authenticationFilterBean;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
	        .csrf(csrf -> csrf.disable())
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authz -> authz
            		.requestMatchers(HttpMethod.POST, "/api/registrovaniKorisnici/prijava").permitAll()
            		.requestMatchers(HttpMethod.POST, "/api/registrovaniKorisnici/registracija").permitAll()
            		.requestMatchers(HttpMethod.GET, "/api/registrovaniKorisnici/{id}").permitAll()
            		.requestMatchers(HttpMethod.PUT, "/api/registrovaniKorisnici/{id}").permitAll()
            		.requestMatchers(HttpMethod.GET, "/api/registrovaniKorisnici/").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.POST, "/api/registrovaniKorisnici/aktiviraj/{id}").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.DELETE, "/api/registrovaniKorisnici/{id}").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.GET, "/api/univerziteti/").permitAll()
            		.requestMatchers(HttpMethod.PUT, "/api/univerziteti/").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.GET, "/api/fakulteti/").permitAll()
            		.requestMatchers(HttpMethod.GET, "/api/fakulteti/{id}").permitAll()
            		.requestMatchers(HttpMethod.POST, "/api/fakulteti/kreiraj").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.PUT, "/api/fakulteti/{id}").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.DELETE, "/api/fakulteti/{id}").hasAuthority("ROLE_ADMIN")
            		.requestMatchers(HttpMethod.GET, "/api/nastavnici/").permitAll()
            		.requestMatchers(HttpMethod.GET, "/api/nastavnici/{id}").permitAll()
            		.requestMatchers(HttpMethod.POST, "/api/nastavnici/kreiraj").hasAuthority("ROLE_ADMIN")
            		.anyRequest().authenticated()
    		)
            .addFilterBefore(authenticationFilterBean, UsernamePasswordAuthenticationFilter.class);

    	return http.build();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept")); 
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration); 
        return source;
    }
}
