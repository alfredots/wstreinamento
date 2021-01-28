package br.com.pulse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pulse.mapper.FilialMapper;
import br.com.pulse.model.Filial;

@Service
public class FilialService {

    @Autowired
    FilialMapper mapper;

    public Filial buscar(Long id){
       return mapper.buscar(id);
    }

    public void salvar(Filial filial) {
        mapper.insert(filial);
    }

    public void atualizar(Filial filial) {
        mapper.update(filial);
    }

    public void remover(Long id) {
        mapper.delete(id);
    }
}
