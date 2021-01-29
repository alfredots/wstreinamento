package br.com.pulse.service;

import br.com.pulse.exception.BusinessException;
import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.service.impl.ProdutoServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {


    private ProdutoServiceImpl service;
    private ProdutoMapper mapper;

    @Before
    public  void setUp() {
        mapper = mock(ProdutoMapper.class);
        service = new ProdutoServiceImpl(mapper);
    }

    @Test
    public void deveRetornarProdutosAcimaMaiorOuIgualACem() {
        //cenario
        int quantidade = 100;
        List<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder().nome("produto1").quantidade(50).build());
        produtos.add(Produto.builder().nome("produto2").quantidade(150).build());
        produtos.add(Produto.builder().nome("produto3").quantidade(50).build());
        produtos.add(Produto.builder().nome("produto4").quantidade(250).build());
        List<Produto> listaRetornada = produtos.stream().filter(produto -> produto.getQuantidade() >= quantidade).collect(Collectors.toList());
        when(service.buscarQuantidade(quantidade)).thenReturn(listaRetornada);

        //ação
        Collection<Produto> produtosRecuperados = service.buscarQuantidade(100);

        //verificar
        assertThat(produtosRecuperados).hasSize(2);
    }

    @Test
    public void deveRetornarExcecaoSeListaVazia() {
        //cenario
        int quantidade = 400;
        List<Produto> listaVazia = new ArrayList<>();
        when(mapper.buscarPorQuantidade(quantidade)).thenReturn(listaVazia);

        //ação
        Throwable exception = catchThrowable(() -> service.buscarQuantidade(quantidade));

        //verificar
        assertThat(exception)
            .isInstanceOf(BusinessException.class)
            .hasMessage("Lista retornou vazia");
    }
}
