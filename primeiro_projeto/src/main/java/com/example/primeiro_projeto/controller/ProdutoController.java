package com.example.primeiro_projeto.controller;

import com.example.primeiro_projeto.model.Produto;
import com.example.primeiro_projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}