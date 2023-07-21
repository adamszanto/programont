package com.example.securityjwt.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtTokenHttpFilter extends OncePerRequestFilter {

    public static final String HEADER_PREFIX = "Bearer ";

    private final JwtTokenGenerator jwtTokenGenerator;

    public JwtTokenHttpFilter(JwtTokenGenerator jwtTokenGenerator) {
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(HEADER_PREFIX)) {
            return Optional.of(bearerToken.replace(HEADER_PREFIX, ""));
        }

        return Optional.empty();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Optional<String> tokenOpt = resolveToken(request);

        if (tokenOpt.isPresent()) {
            String token = tokenOpt.get();

            if (jwtTokenGenerator.validateToken(token)) {
                Authentication authentication = this.jwtTokenGenerator.getAuthentication(token);
                //Thread pool, ehhez a threadhez hozzákötünk egy objektumot = threadLocal objektum. A request pillanatában amig él, addig elérhető.
                // Elérhető ezzel: SecurityContextHolder.getContext()... statikus osztály, BÁRHOL meghivhatjuk... ezért bárhol lekérhetjük.
                // Ezzel az infoval megtudhatjuk hogy ki pl. a bejelentkezett user. Feltöltjük a threadLocal objektumot.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}