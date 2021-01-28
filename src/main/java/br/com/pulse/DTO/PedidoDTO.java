package br.com.pulse.DTO;

import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.model.PedidoEstoque;
import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    PedidoEstoque pedidoEstoque;

    List<ItemDTO> items;
}
