package br.com.pulse.controller;

import br.com.pulse.DTO.PedidoDTO;
import br.com.pulse.service.impl.PedidoEstoqueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidoEstoque")
public class PedidoEstoque {

    PedidoEstoqueServiceImpl service;

    @PostMapping
    public ResponseEntity salvar (@RequestBody PedidoDTO pedido) {
        PedidoEstoque pedidoEstoque = pedido.getPedidoEstoque();

        service.salvar(pedidoEstoque);
    }
}
