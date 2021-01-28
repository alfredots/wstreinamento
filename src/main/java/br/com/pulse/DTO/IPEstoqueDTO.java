package br.com.pulse.DTO;

import br.com.pulse.model.Filial;
import br.com.pulse.model.PedidoEstoque;
import br.com.pulse.model.Produto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IPEstoqueDTO {

    private Long id;

    private int quantidade;

    private Produto produto;

    private PedidoEstoque pedidoEstoque;

    private String tipo;

    private Filial filial;
}
