package br.com.pulse.service.impl;

import br.com.pulse.mapper.ItemPedidoEstoqueMapper;
import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.model.PedidoEstoque;
import br.com.pulse.model.Produto;
import br.com.pulse.service.ItemPedidoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemPedidoEstoqueServiceImpl implements ItemPedidoEstoqueService {

    @Autowired
    ItemPedidoEstoqueMapper mapper;

    @Autowired
    ProdutoServiceImpl produtoService;

    @Autowired
    PedidoEstoqueServiceImpl pedidoEstoqueService;

    @Override
    public Collection<ItemPedidoEstoque> buscarPorProduto(Long produtoId) {
        return mapper.buscarPorProduto(produtoId);
    }

    @Override
    public void salvar(int quantidade, Long produtoId, PedidoEstoque pedidoEstoque) {
        Produto produto = produtoService.buscarPorId(produtoId);
        ItemPedidoEstoque item = ItemPedidoEstoque.builder()
                .pedidoEstoque(pedidoEstoque)
                .produto(produto)
                .quantidade(quantidade)
                .build();
        mapper.insert(item);
    }
}
