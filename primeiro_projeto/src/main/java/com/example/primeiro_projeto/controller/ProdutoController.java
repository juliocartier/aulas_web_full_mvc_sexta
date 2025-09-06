package com.example.primeiro_projeto.controller;

import com.example.primeiro_projeto.model.Produto;
import com.example.primeiro_projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, 
                             @RequestBody Produto produtoAtualizado){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()){
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto nao encontrado = " + id );
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        if (produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return "Produto com id " + id + " deletado";
        } else {
            return "Produto com id " + id + " nao encontrado";
        }
    }
}