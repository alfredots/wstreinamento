package br.com.pulse.model;

import lombok.Data;

@Data
public class ItemPedidoEstoque {

    private Long id;

    private int quantidade;

    private Produto produto;

    private PedidoEstoque pedidoEstoque;
}
