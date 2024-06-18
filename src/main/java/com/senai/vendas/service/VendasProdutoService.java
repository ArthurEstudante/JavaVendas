
package com.senai.vendas.service;

import com.senai.vendas.entity.Produto;
import com.senai.vendas.entity.Vendas;
import com.senai.vendas.entity.VendasProduto;
import com.senai.vendas.repository.VendasProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendasProdutoService {
    
    @Autowired
    private VendasProdutoRepository vendasProdutoRepository;
    
    @Autowired
    private VendasService vendasService;
    
    @Autowired
    private ProdutoService produtoService;
    
    public Long incluirVendaProduto(VendasProduto vendasProduto,
                                    Long IdVendas, Long IdProduto){
        Vendas vendas = vendasService.consultarVendasPorId(IdVendas);
        Produto produto = produtoService.consultarProdutoPorId(IdProduto);
        if(vendas == null ||
           produto == null ||
           vendasProduto.getPrecoVenda() == null ||
           vendasProduto.getQuantidade() == null ||
           vendasProduto.getQuantidade() == 0){
            return null;
        }
        vendasProduto.setProduto(produto);
        vendasProduto.setVendas(vendas);
        return vendasProdutoRepository.save(vendasProduto).getIdVendasProduto();
    }
    
    public boolean excluirVendaProduto(Long IdVendaProduto){
        if(vendasProdutoRepository.existsById(IdVendaProduto)){
            vendasProdutoRepository.deleteById(IdVendaProduto);
            return true;
        }
        return false;
    }
    
    public VendasProduto consultaVendaProdutoPorId(Long IdVendaProduto){
       return vendasProdutoRepository.findById(IdVendaProduto).get();
    }
    
    public List<VendasProduto> listarVendasProdutoPorVendas(Long IdVendas){
        Vendas vendas = vendasService.consultarVendasPorId(IdVendas);
        if(vendas != null){
            return vendasProdutoRepository.findByVendas(vendas);
        }
        return null;
    }
    
    public boolean alterarVendaProduto(VendasProduto vendasProduto){
        VendasProduto vendaProdutoBD = vendasProdutoRepository.getReferenceById(vendasProduto.getIdVendasProduto());
        
        if(vendaProdutoBD != null){
            if(vendasProduto.getPrecoVenda() == null ||
               vendasProduto.getQuantidade() == null ||
               vendasProduto.getQuantidade() == 0){
                return false;
            }
            vendaProdutoBD.setPrecoVenda(vendasProduto.getPrecoVenda());
            vendaProdutoBD.setQuantidade(vendasProduto.getQuantidade());
            vendasProdutoRepository.save(vendaProdutoBD);
            return true;
        }
        return false;
    }
    
}
