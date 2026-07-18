package com.harpreet.aihelpdesk.security.jwt;


import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    /**
     * Base64 encoded secret key
     */
    private String secret;

    /**
     * Access Token Expiration
     */
    private long accessTokenExpiration;

    /**
     * Refresh Token Expiration
     */
    private long refreshTokenExpiration;

    /**
     * Token issuer
     */
    private String issuer;

}