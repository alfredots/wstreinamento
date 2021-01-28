package br.com.pulse.service;

import br.com.pulse.model.Produto;

import java.util.Collection;

public interface ProdutoService {

    Collection<Produto> buscarQuantidade();

    Collection<Produto> buscarPorFilial(Long filialId);

    Produto buscarPorId(Long produtoId);
}
