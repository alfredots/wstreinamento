package br.com.pulse.mapper;

import br.com.pulse.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface ProdutoMapper {

    Produto buscar(Long produtoId);

    Collection<Produto> buscarPorQuantidade(int quantidade);

    Collection<Produto> buscarPorFilial(Long filialId);
}
