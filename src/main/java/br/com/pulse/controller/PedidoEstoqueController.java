package br.com.pulse.controller;

import br.com.pulse.DTO.ItemDTO;
import br.com.pulse.DTO.PedidoDTO;
import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.model.PedidoEstoque;
import br.com.pulse.service.impl.ItemPedidoEstoqueServiceImpl;
import br.com.pulse.service.impl.PedidoEstoqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidoEstoque")
public class PedidoEstoqueController {

    @Autowired
    PedidoEstoqueServiceImpl service;

    @Autowired
    ItemPedidoEstoqueServiceImpl serviceItem;

    @PostMapping
    public ResponseEntity<PedidoEstoque> salvar (@RequestBody PedidoDTO pedido) {
        PedidoEstoque pedidoEstoque = pedido.getPedidoEstoque();
        Long pedidoEstoqueId = service.salvar(pedidoEstoque);

        if (pedidoEstoqueId != null) {
            List<ItemDTO> itens = pedido.getItems();
            itens.forEach(itemDTO -> {
                serviceItem.salvar(itemDTO.getQuantidade(), itemDTO.getProdutoId(), itemDTO.getPedidoEstoqueId());
            });
        }
        return  ResponseEntity.ok(pedidoEstoque);
    }
}
