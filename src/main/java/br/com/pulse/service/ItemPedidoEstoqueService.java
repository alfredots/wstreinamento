package br.com.pulse.service;

import br.com.pulse.DTO.IPEstoqueDTO;
import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.model.PedidoEstoque;

import java.util.Collection;

public interface ItemPedidoEstoqueService {

    Collection<ItemPedidoEstoque> buscarPorProduto(Long produtoId);

    void salvar(int quantidade, Long produtoId, PedidoEstoque pedidoEstoque);
}
