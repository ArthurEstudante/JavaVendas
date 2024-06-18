package com.senai.vendas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vendas_produto")
public class VendasProduto {
  
    @Id
    private Long IdVendasProduto;
    
    @ManyToOne
    @JsonBackReference
    private Vendas vendas;
    
    @OneToOne
    private Produto produto;
    
    @Column(nullable=false)
    private Double precoVenda;
    
    @Column(nullable=false)
    private Integer quantidade;

    
    
    //-----------------------------------------------------------------

    public Long getIdVendasProduto() {
        return IdVendasProduto;
    }

    public void setIdVendasProduto(Long IdVendasProduto) {
        this.IdVendasProduto = IdVendasProduto;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
   
}
