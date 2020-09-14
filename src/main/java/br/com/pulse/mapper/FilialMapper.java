package br.com.pulse.mapper;

import br.com.pulse.model.Filial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface FilialMapper {
    void inserirFilial(@Param("filial")Filial filial);

    boolean atualizarFilial(@Param("filial") Filial filial);

    boolean deletarFilial(@Param("idFilial") Long idFilial);

    List<Filial> listarFiliais();

    Optional<Filial> buscarFilial(@Param("idFilial") Long idFilial);

}
