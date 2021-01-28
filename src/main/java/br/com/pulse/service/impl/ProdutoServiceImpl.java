package br.com.pulse.service.impl;

import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoMapper mapper;

    @Override
    public Collection<Produto> buscarQuantidade() {
        return mapper.buscarPorQuantidade();
    }

    @Override
    public Collection<Produto> buscarPorFilial(Long filialId) {
        return mapper.buscarPorFilial(filialId);
    }

    @Override
    public Produto buscarPorId(Long produtoId) {
        return mapper.buscar(produtoId);
    }
}
