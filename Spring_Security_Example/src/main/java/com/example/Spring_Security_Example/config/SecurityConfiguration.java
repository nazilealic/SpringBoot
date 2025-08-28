package com.example.Spring_Security_Example.config;

import com.example.Spring_Security_Example.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // DB’den kullanıcıları kontrol eden AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                var userDetails = customUserDetailsService
                        .loadUserByUsername(authentication.getName());

                if (!passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
                    throw new BadCredentialsException("Invalid password");
                }

                return new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(),
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/dashboard").hasAnyRole("ADMIN", "USER") // admin + user erişebilir
                        .requestMatchers("/admin").hasRole("ADMIN") // sadece admin erişebilir
                        .requestMatchers("/index").permitAll() // index herkese açık
                        .anyRequest().authenticated() // diğer tüm istekler login gerektirir
                )


                .formLogin(Customizer.withDefaults()) // login sayfası
                .httpBasic(Customizer.withDefaults()); // basic auth

        return http.build();
    }
}
