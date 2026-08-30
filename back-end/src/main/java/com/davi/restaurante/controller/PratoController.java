package com.davi.restaurante.controller;

import com.davi.restaurante.records.request.PratoRecord;
import com.davi.restaurante.records.response.PratoResponseRecord;
import com.davi.restaurante.services.PratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
public class PratoController {
    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<PratoResponseRecord> criarPrato(@RequestBody @Valid PratoRecord prato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pratoService.adicionarPrato(prato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PratoResponseRecord> editarPrato(@PathVariable Long id, @RequestParam @Valid PratoRecord prato) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pratoService.editarPrato(id, prato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PratoResponseRecord> apagar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.pratoService.apagar(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoResponseRecord> pratoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pratoService.pratoId(id));
    }

    @GetMapping
    public ResponseEntity<List<PratoResponseRecord>> todosPratos() {
        return ResponseEntity.status(HttpStatus.OK).body(pratoService.todosPratos());
    }
}