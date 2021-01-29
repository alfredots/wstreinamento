package br.com.pulse.controller;

import br.com.pulse.exception.BusinessException;
import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.service.impl.ProdutoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;

public class ProdutoControllerTest {

    private ProdutoController controller;
    private ProdutoServiceImpl service;
    private ProdutoMapper mapper;

    private static String PRODUTO_API = "/api/books";

    @Before
    public void setUp() {
        mapper = mock(ProdutoMapper.class);
        service = new ProdutoServiceImpl(mapper);
        controller = new ProdutoController(service);
    }

    @Test
    public void deveRetornarProdutosComQuantidadeAcimaDeCem() {
        // cenario
        int quantidade = 100;
        Collection<Produto> produtos = new ArrayList<>();
        produtos.add(Produto.builder().nome("produto1").quantidade(50).build());
        produtos.add(Produto.builder().nome("produto2").quantidade(150).build());
        produtos.add(Produto.builder().nome("produto3").quantidade(50).build());
        produtos.add(Produto.builder().nome("produto4").quantidade(250).build());
        List<Produto> listaRetornada = produtos.stream().filter(produto -> produto.getQuantidade() >= quantidade).collect(Collectors.toList());
        BDDMockito.given(service.buscarQuantidade(quantidade)).willReturn(listaRetornada);

        // ação
        ResponseEntity<Collection<Produto>> response = controller.produtosAcimaCem();

        //verificar
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(2);
    }

    @Test
    public void deveRetornarExcecaoCasoNenhumProdutoRetornado() {
        // cenario
        int quantidade = 400;
        Collection<Produto> produtos = new ArrayList<>();
        BDDMockito.given(mapper.buscarPorQuantidade(quantidade)).willReturn(produtos);
        // ação
        Throwable exception = catchThrowable(() -> controller.produtosAcimaCem());

        //verificar
        assertThat(exception)
                .isInstanceOf(BusinessException.class)
                .hasMessage("Lista retornou vazia");
    }
}
