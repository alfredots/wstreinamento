package br.com.pulse.service.impl;

import br.com.pulse.mapper.ItemPedidoEstoqueMapper;
import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.service.ItemPedidoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemPedidoEstoqueServiceImpl implements ItemPedidoEstoqueService {

    @Autowired
    ItemPedidoEstoqueMapper mapper;

    @Override
    public Collection<ItemPedidoEstoque> buscarPorProduto(Long produtoId) {
        return mapper.buscarPorProduto(produtoId);
    }
}
