package com.generation.loja_games.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.loja_games.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}