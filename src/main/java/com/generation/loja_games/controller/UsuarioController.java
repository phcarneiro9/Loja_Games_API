package com.generation.loja_games.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_games.model.Usuario;
import com.generation.loja_games.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) {

        if (usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuarioExistente = usuarioRepository.findById(usuario.getId()).get();

        usuario.setSenha(usuarioExistente.getSenha());

        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}