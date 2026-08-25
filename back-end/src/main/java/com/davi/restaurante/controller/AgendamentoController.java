package com.davi.restaurante.controller;

import com.davi.restaurante.records.request.AgendamentoRecord;
import com.davi.restaurante.records.response.AgendamentoResponseRecord;
import com.davi.restaurante.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    public AgendamentoController() {
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseRecord> agendar(@RequestBody @Valid AgendamentoRecord agendamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.agendar(agendamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseRecord> editar(@PathVariable Long id, @RequestBody @Valid AgendamentoRecord agendamento) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.editarAgendamento(id, agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgendamentoResponseRecord> cancelar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.cancelarAgendamento(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseRecord>> todosAgendamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.todosAgendamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseRecord> agendamentoId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.agendamentoId(id));
    }

    @GetMapping("/data/{mesa}")
    public ResponseEntity<List<AgendamentoResponseRecord>> agendamentoDoDia(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate data, @PathVariable("mesa") Integer numero_mesa) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.agendamentoDoDia(data, numero_mesa));
    }
}