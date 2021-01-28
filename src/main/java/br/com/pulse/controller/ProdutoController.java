package br.com.pulse.controller;

import br.com.pulse.model.Produto;
import br.com.pulse.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl service;

    @GetMapping
    public ResponseEntity<Collection<Produto>> produtosAcimaCem() {
        Collection<Produto> produtos = service.buscarQuantidade();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("search")
    public ResponseEntity<Collection<Produto>> buscarPorFilial( @RequestParam("filial") Long filialId) {
        Collection<Produto> produtos = service.buscarPorFilial(filialId);
        return ResponseEntity.ok(produtos);
    }

}
