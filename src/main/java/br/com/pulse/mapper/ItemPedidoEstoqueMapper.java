package br.com.pulse.mapper;

import br.com.pulse.DTO.IPEstoqueDTO;
import br.com.pulse.model.ItemPedidoEstoque;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Mapper
@Repository
public interface ItemPedidoEstoqueMapper {

    ItemPedidoEstoque buscar(@Param("itemPedidoEstoqueId") Long itemPedidoId);

    Collection<ItemPedidoEstoque> buscarPorProduto(@Param("produtoId") Long produtoId);

    void insert(@Param("item") ItemPedidoEstoque item);
}
