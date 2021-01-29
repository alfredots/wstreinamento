package br.com.pulse.service.impl;

import br.com.pulse.model.Filial;
import br.com.pulse.model.PedidoEstoque;
import br.com.pulse.mapper.PedidoEstoqueMapper;
import br.com.pulse.service.FilialService;
import br.com.pulse.service.PedidoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoEstoqueServiceImpl implements PedidoEstoqueService {

    @Autowired
    PedidoEstoqueMapper mapper;
    @Autowired
    FilialService filialService;

    @Override
    public PedidoEstoque salvar(String tipo, Long filialId) {
        Filial filial = filialService.buscar(filialId);
        PedidoEstoque pedidoEstoque = PedidoEstoque.builder()
                .tipo(tipo)
                .filial(filial)
                .build();
        mapper.insert(pedidoEstoque);
        return pedidoEstoque;
    }

    @Override
    public PedidoEstoque buscarPorId(Long pedidoEstoqueId) {
        return mapper.buscar(pedidoEstoqueId);
    }


}
