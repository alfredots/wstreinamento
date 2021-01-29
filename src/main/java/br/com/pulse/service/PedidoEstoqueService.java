package br.com.pulse.service;

import br.com.pulse.model.PedidoEstoque;

public interface PedidoEstoqueService {

    PedidoEstoque salvar(String tipo, Long filialId);

    PedidoEstoque buscarPorId(Long pedidoEstoqueId);
}
