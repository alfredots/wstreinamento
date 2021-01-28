package br.com.pulse.DTO;

import lombok.Data;

@Data
public class ItemDTO {

    Long id;
    int quantidade;
    Long produtoId;
    Long pedidoEstoqueId;
}
