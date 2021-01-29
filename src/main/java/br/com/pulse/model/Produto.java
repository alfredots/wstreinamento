package br.com.pulse.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {

    private Long id;

    private String nome;

    private int quantidade;
}
