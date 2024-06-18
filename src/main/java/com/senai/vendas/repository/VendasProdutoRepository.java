package com.senai.vendas.repository;

import com.senai.vendas.entity.Vendas;
import com.senai.vendas.entity.VendasProduto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasProdutoRepository extends JpaRepository<VendasProduto, Long>{
    
    List<VendasProduto> findByVendas(Vendas vandas);
}
