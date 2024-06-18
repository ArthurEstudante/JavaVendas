package com.senai.vendas.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdCliente;
    
    @Column(nullable=false)
    private String nome;
    
    @Column(nullable=false)
    private String email;
    
    @Column(length = 11, unique=true, nullable=false)
    private String cpf;
    
    @Column(nullable=true)
    private String celular;
    
    @Column(nullable=false)
    private Date nascimento;
    
    
    @OneToMany(mappedBy="cliente", fetch=FetchType.LAZY,
            orphanRemoval = true, cascade = CascadeType.ALL) 
    @JsonManagedReference //Gerencia referência entre objetos
    private Set<Vendas> vendas;
    
   //MÉTODOS get e setters -----------------------------------------------------
    
    public Long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Long IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Set<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Vendas> vendas) {
        this.vendas = vendas;
    }
    
    
}
