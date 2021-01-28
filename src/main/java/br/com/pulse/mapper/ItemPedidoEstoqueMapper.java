package br.com.pulse.mapper;

import br.com.pulse.DTO.IPEstoqueDTO;
import br.com.pulse.model.ItemPedidoEstoque;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Mapper
@Repository
public interface ItemPedidoEstoqueMapper {

    ItemPedidoEstoque buscar(Long itemPedidoId);

    Collection<ItemPedidoEstoque> buscarPorProduto(Long produtoId);

    void insert(ItemPedidoEstoque item);
}
