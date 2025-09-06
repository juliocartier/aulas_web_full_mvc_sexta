package com.example.primeiro_projeto.model;

import jakarta.persistence.*;

@Entity
public class Produto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    public Produto (){}

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId(){
        return id;
    }

     public String getNome(){
        return nome;
     }

     public void setNome(String nome){
        this.nome = nome;
     }

     public Double getPreco() {
        return preco;
     }

     public void setPreco(Double preco){
        this.preco = preco;
     }
}