package br.com.pulse.service.impl;

import br.com.pulse.exception.ServiceException;
import br.com.pulse.mapper.FilialMapper;
import br.com.pulse.model.Filial;
import br.com.pulse.service.IFilialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilialService implements IFilialService {

    private final FilialMapper filialMapper;

    @Override
    public Filial salvarFilial(Filial filial) {
        filialMapper.inserirFilial(filial);

        if(filial.getIdFilial() == null){
            log.error("Erro ao salvar filial");
            throw new ServiceException("Erro ao salvar filial");
        }

        return filial;
    }

    @Override
    public Filial atualizarFilial(Filial filial) {
        if(buscarFilial(filial.getIdFilial()).isPresent()){
            boolean filialAlterado = filialMapper.atualizarFilial(filial);

            if(!filialAlterado){
                log.error("Erro ao alterar filial");
                throw new ServiceException("Erro ao alterar filial");
            }
        }

        return filial;
    }

    @Override
    public void deletarFilial(Long idFilial) {
        boolean deletado = filialMapper.deletarFilial(idFilial);
        if(!deletado){
            log.error("Erro ao deletar filial");
            throw new ServiceException("Erro ao deletar filial");
        }
    }

    @Override
    public List<Filial> listarFiliais() {
        List<Filial> filiaisCadastradas = filialMapper.listarFiliais();
        if(filiaisCadastradas.isEmpty()) throw new ServiceException("Sem filiais cadastradas ainda");
        return filiaisCadastradas;
    }

    @Override
    public Optional<Filial> buscarFilial(Long idFilial) {
        Optional<Filial> filialBuscado = filialMapper.buscarFilial(idFilial);
        if(!filialBuscado.isPresent()){
            log.error("Produto buscado não existe");
            throw new ServiceException("Filial com id " + idFilial + " inexistente");
        }
        return filialBuscado;
    }
}
