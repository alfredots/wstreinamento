package br.com.pulse.model;

import lombok.Data;

import java.util.Collection;

@Data
public class PedidoEstoque {

    private Long id;

    private String tipo;

    private Filial filial;
}
