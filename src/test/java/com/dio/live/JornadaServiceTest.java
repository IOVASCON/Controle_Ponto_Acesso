package com.dio.live;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import com.dio.live.service.JornadaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JornadaServiceTest {

    @InjectMocks
    JornadaService jornadaService;

    @Mock
    JornadaRepository jornadaRepository;

    JornadaTrabalho jornadaTrabalho;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jornadaTrabalho = JornadaTrabalho.builder()
                .id(1L)
                .descricao("Teste de Jornada")
                .build();
    }

    @Test
    public void testSaveJornada() {
        when(jornadaRepository.save(jornadaTrabalho)).thenReturn(jornadaTrabalho);
        JornadaTrabalho savedJornada = jornadaService.saveJornada(jornadaTrabalho);
        assertNotNull(savedJornada);
        assertEquals(jornadaTrabalho.getDescricao(), savedJornada.getDescricao());
    }

    @Test
    public void testFindById() {
        when(jornadaRepository.findById(1L)).thenReturn(Optional.of(jornadaTrabalho));
        Optional<JornadaTrabalho> foundJornada = jornadaService.getById(1L);
        assertTrue(foundJornada.isPresent());
        assertEquals(jornadaTrabalho.getDescricao(), foundJornada.get().getDescricao());
    }

    @Test
    public void testDeleteJornada() {
        when(jornadaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(jornadaRepository).deleteById(1L);
        jornadaService.deleteJornada(1L);
        verify(jornadaRepository, times(1)).deleteById(1L);
    }
}
