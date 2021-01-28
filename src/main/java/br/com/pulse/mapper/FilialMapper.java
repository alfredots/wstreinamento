package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.Filial;

@Mapper
@Repository
public interface FilialMapper {

  Filial buscar(Long filialId);

  void delete (Long filialId);

  void insert(@Param("filial") Filial filial);

  void update(@Param("filial") Filial filial);
}