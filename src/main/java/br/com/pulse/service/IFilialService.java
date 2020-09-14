package br.com.pulse.service;

import br.com.pulse.model.Filial;

import java.util.List;
import java.util.Optional;

public interface IFilialService {

    Filial salvarFilial(Filial filial);

    Filial atualizarFilial(Filial filial);

    void deletarFilial(Long idFilial);

    List<Filial> listarFiliais();

    Optional<Filial> buscarFilial(Long idFilial);
}
