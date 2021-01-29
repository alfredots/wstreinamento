package br.com.pulse.mapper;

import br.com.pulse.model.PedidoEstoque;
import org.apache.ibatis.annotations.Param;

public interface PedidoEstoqueMapper {

    public PedidoEstoque buscar(@Param("pedidoEstoqueId") Long pedidoEstoqueId);

    void insert(@Param("pedidoEstoque") PedidoEstoque pedidoEstoque);
}
