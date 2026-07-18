package com.harpreet.aihelpdesk.security.filter;

import com.harpreet.aihelpdesk.constants.SecurityConstants;
import com.harpreet.aihelpdesk.security.jwt.JwtService;
import com.harpreet.aihelpdesk.security.userDetails.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        try {

            String authHeader = request.getHeader(
                    SecurityConstants.AUTHORIZATION_HEADER
            );

            if (authHeader == null
                    || !authHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {

                filterChain.doFilter(request, response);
                return;
            }

            String jwt = authHeader.substring(
                    SecurityConstants.TOKEN_PREFIX_LENGTH
            );

            String username = jwtService.extractUsername(jwt);

            if (username != null
                    && SecurityContextHolder
                    .getContext()
                    .getAuthentication() == null) {

                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(username);

                if (jwtService.validateToken(jwt, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(

                                    userDetails,

                                    null,

                                    userDetails.getAuthorities()

                            );

                    authentication.setDetails(

                            new WebAuthenticationDetailsSource()

                                    .buildDetails(request)

                    );

                    SecurityContextHolder

                            .getContext()

                            .setAuthentication(authentication);

                }

            }

        } catch (Exception ex) {

            log.error("JWT Authentication Failed : {}", ex.getMessage());

        }

        filterChain.doFilter(request, response);

    }

}