package br.com.pulse.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PedidoEstoque {

    private Long id;

    private String tipo;

    private Filial filial;
}
