package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        JornadaTrabalho createdJornada = jornadaService.saveJornada(jornadaTrabalho);
        return new ResponseEntity<>(createdJornada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getJornadaList() {
        List<JornadaTrabalho> jornadas = jornadaService.findAll();
        return new ResponseEntity<>(jornadas, HttpStatus.OK);
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        JornadaTrabalho jornada = jornadaService.getById(idJornada)
                .orElseThrow(() -> new NoSuchElementException("Not found!"));
        return new ResponseEntity<>(jornada, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> updateJornada(@PathVariable("id") Long id,
            @RequestBody JornadaTrabalho jornadaTrabalho) {
        jornadaTrabalho.setId(id); // Garante que o id passado na URL seja usado no objeto JornadaTrabalho
        JornadaTrabalho updatedJornada = jornadaService.updateJornada(id, jornadaTrabalho);
        return ResponseEntity.ok(updatedJornada);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<String> deleteByID(@PathVariable("idJornada") Long idJornada) {
        try {
            jornadaService.deleteJornada(idJornada);
            return new ResponseEntity<>("Jornada deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
