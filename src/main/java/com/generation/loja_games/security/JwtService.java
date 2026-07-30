package com.generation.loja_games.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String CHAVE_SECRETA =
            "loja-games-chave-jwt-segura-com-mais-de-32-caracteres";

    private static final long TEMPO_EXPIRACAO = 60 * 60 * 1000;

    private SecretKey getChave() {

        return Keys.hmacShaKeyFor(
                CHAVE_SECRETA.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String gerarToken(String email) {

        Date agora = new Date();

        Date expiracao = new Date(
                agora.getTime() + TEMPO_EXPIRACAO
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(getChave())
                .compact();
    }

    public String extrairEmail(String token) {

        return extrairClaims(token).getSubject();
    }

    public boolean tokenValido(String token, String email) {

        String emailToken = extrairEmail(token);

        return emailToken.equals(email)
                && !tokenExpirado(token);
    }

    private boolean tokenExpirado(String token) {

        return extrairClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims extrairClaims(String token) {

        return Jwts.parser()
                .verifyWith(getChave())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}