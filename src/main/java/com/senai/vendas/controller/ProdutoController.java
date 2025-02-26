package com.senai.vendas.controller;

import com.senai.vendas.entity.Produto;
import com.senai.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    
    
    // (Get) http://localhost:8010/venda/produto/10
    @GetMapping("/produto/{IdProduto}") 
    public ResponseEntity<Produto> consultaProdutoPorId(@PathVariable("IdProduto")
                                                        Long IdProduto){
        Produto produto = produtoService.consultarProdutoPorId(IdProduto);
        if(produto != null){
            return new ResponseEntity<>(produto,HttpStatus.OK);
        }
        return new ResponseEntity<>(produto,HttpStatus.NOT_FOUND);
    }
    
    
    
}
