package com.generation.loja_games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.loja_games.model.Pedido;
import com.generation.loja_games.repository.PedidoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoRepository.save(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> put(@Valid @RequestBody Pedido pedido) {

        Optional<Pedido> buscaPedido = pedidoRepository.findById(pedido.getId());

        if (buscaPedido.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Optional<Pedido> buscaPedido = pedidoRepository.findById(id);

        if (buscaPedido.isEmpty())
            return ResponseEntity.notFound().build();

        pedidoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}