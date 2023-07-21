package com.example.securityjwt.config;

import com.example.securityjwt.security.JwtTokenHttpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
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
@EnableMethodSecurity
public class WebSecurityConfiguration {

    private CorsConfigurationSource createCorsConfigSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin(CorsConfiguration.ALL);
        config.addAllowedHeader(CorsConfiguration.ALL);
        config.addAllowedMethod(CorsConfiguration.ALL);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtTokenHttpFilter jwtTokenHttpFilter) throws Exception {
        return httpSecurity
                .addFilterBefore(jwtTokenHttpFilter, UsernamePasswordAuthenticationFilter.class)
                .cors().configurationSource(createCorsConfigSource())
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req, res, exc) -> res.setStatus(HttpStatus.UNAUTHORIZED.value()))
                .accessDeniedHandler((req, res, exc) -> res.setStatus(HttpStatus.FORBIDDEN.value()))
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers("/registration").permitAll()
                .requestMatchers("/authentication").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
