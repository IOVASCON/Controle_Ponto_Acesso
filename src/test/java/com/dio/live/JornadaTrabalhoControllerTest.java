package com.dio.live;

import com.dio.live.controller.JornadaTrabalhoController;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class JornadaTrabalhoControllerTest {

    @InjectMocks
    JornadaTrabalhoController jornadaTrabalhoController;

    @Mock
    JornadaService jornadaService;

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
    public void testGetJornadaById() throws Exception {
        when(jornadaService.getById(1L)).thenReturn(Optional.of(jornadaTrabalho));
        ResponseEntity<JornadaTrabalho> response = jornadaTrabalhoController.getJornadaByID(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificação para lidar com potencial retorno nulo do getBody
        JornadaTrabalho body = response.getBody();
        assertNotNull(body, "O corpo da resposta não deve ser nulo");
        assertEquals(jornadaTrabalho.getDescricao(), body.getDescricao());
    }

    @Test
    public void testCreateJornada() {
        when(jornadaService.saveJornada(jornadaTrabalho)).thenReturn(jornadaTrabalho);
        ResponseEntity<JornadaTrabalho> response = jornadaTrabalhoController.createJornada(jornadaTrabalho);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificação para lidar com potencial retorno nulo do getBody
        JornadaTrabalho body = response.getBody();
        assertNotNull(body, "O corpo da resposta não deve ser nulo");
        assertEquals(jornadaTrabalho.getDescricao(), body.getDescricao());
    }
}
