
package com.senai.vendas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="vendas")
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdVendas;
    
    @ManyToOne
    @JsonBackReference //Gerenciar referência entre objetos
    private Cliente cliente;
    
    @OneToMany(mappedBy="vendas", fetch=FetchType.LAZY,
            orphanRemoval = true, cascade = CascadeType.ALL) 
    @JsonManagedReference
    private Set<VendasProduto> vendasProduto;
    
    @Column(nullable=false)
    private Date dataVendas;
    
    @Column(nullable=false)
    private int situacao;

    // ---------------------------------------------------------------------
    
    
    public Long getIdVendas() {
        return IdVendas;
    }

    public void setIdVendas(Long IdVendas) {
        this.IdVendas = IdVendas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVendas() {
        return dataVendas;
    }

    public void setDataVendas(Date dataVendas) {
        this.dataVendas = dataVendas;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
      public Set<VendasProduto> getVendasProduto() {
        return vendasProduto;
    }

    public void setVendasProduto(Set<VendasProduto> vendasProduto) {
        this.vendasProduto = vendasProduto;
    }
     
}
