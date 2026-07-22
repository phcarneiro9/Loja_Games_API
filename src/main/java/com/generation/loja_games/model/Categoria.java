package com.generation.loja_games.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo é obrigatório!")
    @Size(min = 3, max = 100)
    private String tipo;

    @NotBlank(message = "A descrição é obrigatória!")
    @Size(min = 5, max = 255)
    private String descricao;


    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}