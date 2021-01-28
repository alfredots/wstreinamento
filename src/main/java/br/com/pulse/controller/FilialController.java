package br.com.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pulse.model.Filial;
import br.com.pulse.service.FilialService;

@RestController
@RequestMapping("/filial")
public class FilialController {
    
    @Autowired
    FilialService service;

    @GetMapping("/{id}")
    public ResponseEntity<Filial> buscar(@PathVariable Long id){
       Filial retorno = service.buscar(id);
       
       if(retorno == null){
            return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Filial> salvar(@RequestBody Filial item){
        Filial filialSalva = service.salvar(item);

        return ResponseEntity.ok(filialSalva);
    }

    @PutMapping
    public void atualizar(@RequestBody Filial item) {
        service.atualizar(item);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id) {
        service.remover(id);
    }
}
