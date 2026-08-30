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

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<AgendamentoResponseRecord> cancelar(@PathVariable Long userId, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.cancelarAgendamento(userId, id));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseRecord>> todosAgendamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.todosAgendamentos());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AgendamentoResponseRecord>> usuarioTodosAgendamentos(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.usuarioTodosAgendamentos(userId));
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<AgendamentoResponseRecord> agendamentoId(@PathVariable Long userId, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.agendamentoId(userId, id));
    }

    @GetMapping("/{userId}/data/{numero_mesa}")
    public ResponseEntity<List<AgendamentoResponseRecord>> agendamentoDoDia(@PathVariable Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data, @PathVariable("numero_mesa") Integer mesa) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.agendamentoDoDia(userId, data, mesa));
    }
}