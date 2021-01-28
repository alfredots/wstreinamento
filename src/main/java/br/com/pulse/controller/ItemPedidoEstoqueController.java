package br.com.pulse.controller;

import br.com.pulse.DTO.IPEstoqueDTO;
import br.com.pulse.model.ItemPedidoEstoque;
import br.com.pulse.service.impl.ItemPedidoEstoqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itemPedidoEstoque")
public class ItemPedidoEstoqueController {

    @Autowired
    ItemPedidoEstoqueServiceImpl service;

    @GetMapping("search")
    public ResponseEntity<Collection<IPEstoqueDTO>> buscarPorProduto(@RequestParam("produto") Long produtoId) {
        Collection<ItemPedidoEstoque> itemPedidos = service.buscarPorProduto(produtoId);
        Collection<IPEstoqueDTO> pedidos = itemPedidos.stream().map(itemPedidoEstoque -> {
            return IPEstoqueDTO.builder()
                    .id(itemPedidoEstoque.getId())
                    .quantidade(itemPedidoEstoque.getQuantidade())
                    .produtoId(itemPedidoEstoque.getProduto().getId())
                    .tipo(itemPedidoEstoque.getPedidoEstoque().getTipo())
                    .pedidoEstoqueId(itemPedidoEstoque.getPedidoEstoque().getId())
                    .filialId(itemPedidoEstoque.getPedidoEstoque().getFilial().getId())
                    .build();
        }).collect(Collectors.toList());

        return ResponseEntity.ok(pedidos);
    }
}
