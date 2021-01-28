package br.com.pulse.service.impl;

import br.com.pulse.model.PedidoEstoque;
import br.com.pulse.mapper.PedidoEstoqueMapper;
import br.com.pulse.service.PedidoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoEstoqueServiceImpl implements PedidoEstoqueService {

    @Autowired
    PedidoEstoqueMapper mapper;


    @Override
    public Long salvar(PedidoEstoque pedidoEstoque) {
        mapper.insert(pedidoEstoque);
        return pedidoEstoque.getId();
    }

    @Override
    public PedidoEstoque buscarPorId(Long pedidoEstoqueId) {
        return mapper.buscar(pedidoEstoqueId);
    }


}
