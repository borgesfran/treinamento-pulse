package br.com.pulse.mapper;

import br.com.pulse.model.Estoque;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface EstoqueMapper {

    void inserirEstoque(@Param("estoque")Estoque estoque);

    boolean atualizarEstoque(@Param("estoque") Estoque estoque);

    boolean deletarEstoque(@Param("idEstoque") Long idEstoque);

    Optional<Estoque> buscarEstoquePorProdutoEFilial(@Param("idProduto") Long idProduto, @Param("idFilial") Long idFilial);

    List<Estoque> listarEstoques();

    List<Estoque> listarEstoquePorProduto(@Param("idProduto") Long idProduto);

    List<Estoque> listarEstoquePorFilial(@Param("idFilial") Long idFilial);

}
