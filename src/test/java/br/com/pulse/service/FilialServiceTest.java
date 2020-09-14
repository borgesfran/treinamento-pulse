package br.com.pulse.service;

import br.com.pulse.exception.ServiceException;
import br.com.pulse.mapper.FilialMapper;
import br.com.pulse.model.Filial;
import br.com.pulse.service.impl.FilialService;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

public class FilialServiceTest {

    private IFilialService filialService;
    private FilialMapper filialMapper;
    private EasyRandom random;

    @Before
    public void iniciar(){
        filialMapper = Mockito.mock(FilialMapper.class);
        filialService = new FilialService(filialMapper);
        random = new EasyRandom();
    }

    @Test
    public void deveTestarBuscarFilialUnicaComSucesso(){
        Filial filial = random.nextObject(Filial.class);
        Mockito.when(filialMapper.buscarFilial(ArgumentMatchers.anyLong())).thenReturn(Optional.of(filial));
        Optional <Filial> filialBuscada = filialService.buscarFilial(1L);
        Assertions.assertThat(filialBuscada).hasValue(filial);
    }

    @Test
    public void deveTestarBuscarFilialUnicaComExcecao(){
        Filial filial = random.nextObject(Filial.class);
        Mockito.when(filialMapper.buscarFilial(3L)).thenReturn(Optional.of(filial));
        Assertions
                .assertThatThrownBy(()->filialService.buscarFilial(1L))
                .isExactlyInstanceOf(ServiceException.class)
                .hasMessage("Filial com id 1 inexistente");
    }
}
