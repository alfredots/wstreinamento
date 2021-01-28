package br.com.pulse.model;

import lombok.Data;

@Data
public class PedidoEstoque {

    private Long id;

    private String tipo;

    private Filial filial;
}
