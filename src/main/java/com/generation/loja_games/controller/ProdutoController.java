package com.generation.loja_games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_games.model.Produto;
import com.generation.loja_games.repository.ProdutoRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;



    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {

        return ResponseEntity.ok(produtoRepository.findAll());

    }



    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {

            return ResponseEntity.ok(produto.get());

        }

        return ResponseEntity.notFound().build();

    }



    // Buscar produto pelo nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(
            @PathVariable String nome) {

        return ResponseEntity.ok(
                produtoRepository.findAllByNomeContainingIgnoreCase(nome)
        );

    }



    // Cadastrar produto
    @PostMapping
    public ResponseEntity<Produto> post(
            @Valid @RequestBody Produto produto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produto));

    }



    // Atualizar produto
    @PutMapping
    public ResponseEntity<Produto> put(
            @Valid @RequestBody Produto produto) {

        if (produtoRepository.existsById(produto.getId())) {

            return ResponseEntity.ok(
                    produtoRepository.save(produto)
            );

        }

        return ResponseEntity.notFound().build();

    }



    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        if (produtoRepository.existsById(id)) {

            produtoRepository.deleteById(id);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}