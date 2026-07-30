package com.generation.loja_games.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_games.model.Usuario;
import com.generation.loja_games.repository.UsuarioRepository;
import com.generation.loja_games.security.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody Usuario usuario) {

        if (usuario.getIdade() < 18) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("O usuário precisa ter 18 anos ou mais.");
        }

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("E-mail já cadastrado.");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        usuarioSalvo.setSenha(null);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioSalvo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuario.getEmail(),
                            usuario.getSenha()
                    )
            );

            String token = jwtService.gerarToken(usuario.getEmail());

            Map<String, String> resposta = new HashMap<>();
            resposta.put("token", token);

            return ResponseEntity.ok(resposta);

        } catch (BadCredentialsException exception) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("E-mail ou senha inválidos.");
        }
    }
}