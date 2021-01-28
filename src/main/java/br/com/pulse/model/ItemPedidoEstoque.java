package br.com.pulse.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemPedidoEstoque {

    private Long id;

    private int quantidade;

    private Produto produto;

    private PedidoEstoque pedidoEstoque;
}
