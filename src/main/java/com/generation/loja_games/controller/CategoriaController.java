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

import com.generation.loja_games.model.Categoria;
import com.generation.loja_games.repository.CategoriaRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    @Autowired
    private CategoriaRepository categoriaRepository;



    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {

        return ResponseEntity.ok(categoriaRepository.findAll());

    }



    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if(categoria.isPresent()) {

            return ResponseEntity.ok(categoria.get());

        }

        return ResponseEntity.notFound().build();

    }



    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Categoria>> getByTipo(@PathVariable String tipo){

        return ResponseEntity.ok(
                categoriaRepository.findAllByTipoContainingIgnoreCase(tipo)
        );

    }



    @PostMapping
    public ResponseEntity<Categoria> post(
            @Valid @RequestBody Categoria categoria){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaRepository.save(categoria));

    }



    @PutMapping
    public ResponseEntity<Categoria> put(
            @Valid @RequestBody Categoria categoria){

        if(categoriaRepository.existsById(categoria.getId())) {

            return ResponseEntity.ok(
                    categoriaRepository.save(categoria)
            );

        }

        return ResponseEntity.notFound().build();

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        if(categoriaRepository.existsById(id)) {

            categoriaRepository.deleteById(id);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}