package br.com.pulse.service;

import br.com.pulse.model.PedidoEstoque;

public interface PedidoEstoqueService {

    Long salvar(PedidoEstoque pedidoEstoque);

    PedidoEstoque buscarPorId(Long pedidoEstoqueId);
}
