package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaService {

    private final JornadaRepository jornadaRepository; // Removendo o @Autowired, pois é desnecessário com injeção dE
                                                       // dependência no construtor

    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho updateJornada(Long id, JornadaTrabalho jornadaTrabalho) {
        Optional<JornadaTrabalho> existingJornada = jornadaRepository.findById(id);
        if (existingJornada.isPresent()) {
            jornadaTrabalho.setId(id); // Garante que o ID passado seja mantido no objeto
            return jornadaRepository.save(jornadaTrabalho);
        } else {
            throw new RuntimeException("Jornada não encontrada para atualização");
        }
    }

    public void deleteJornada(Long idJornada) {
        if (jornadaRepository.existsById(idJornada)) {
            jornadaRepository.deleteById(idJornada);
        } else {
            throw new RuntimeException("Jornada não encontrada para exclusão");
        }
    }
}
