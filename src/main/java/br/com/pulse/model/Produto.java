package br.com.pulse.model;

import lombok.Data;

@Data
public class Produto {

    private Long id;

    private String nome;

    private int quantidade;
}
