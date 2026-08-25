package com.davi.restaurante.services;

import com.davi.restaurante.entity.AgendamentoEntity;
import com.davi.restaurante.entity.MesaEntity;
import com.davi.restaurante.exceptions.AgendamentoException;
import com.davi.restaurante.records.request.AgendamentoRecord;
import com.davi.restaurante.records.response.AgendamentoResponseRecord;
import com.davi.restaurante.repository.AgendamentoRepository;
import com.davi.restaurante.repository.MesaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private MesaRepository mesaRepository;

    public AgendamentoService() {
    }

    public AgendamentoResponseRecord agendar(AgendamentoRecord record) {
        AgendamentoEntity agendamento = new AgendamentoEntity();

        if (this.repository.existeConflitoNoAgendamento(record.data(), calcHoras(record.data(), record.duracao()), record.mesa().numero(), agendamento.getId()))
            throw new AgendamentoException("O tempo de agendamento gera conflito com os demais agendamentos", HttpStatus.CONFLICT);

        BeanUtils.copyProperties(record, agendamento);
        MesaEntity mesa = this.mesaRepository.findByNumero(record.mesa().numero()).orElseThrow();
        agendamento.setMesa(mesa);

        this.repository.save(agendamento);
        return new AgendamentoResponseRecord(agendamento);
    }

    public AgendamentoResponseRecord cancelarAgendamento(Long id) {
        AgendamentoEntity agendamento = this.repository.findById(id).orElseThrow(() -> new AgendamentoException("Nenhum agendamento encontrado", HttpStatus.NOT_FOUND));

        this.repository.delete(agendamento);

        return new AgendamentoResponseRecord(agendamento);
    }

    public AgendamentoResponseRecord editarAgendamento(Long id, AgendamentoRecord record) {
        AgendamentoEntity agendamento = this.repository.findById(id)
                .orElseThrow(() -> new AgendamentoException("Nenhum agendamento encontrado", HttpStatus.NOT_FOUND));

        MesaEntity mesa = this.mesaRepository.findByNumero(record.mesa().numero())
                .orElseThrow(() -> new AgendamentoException("Mesa informada não encontrada", HttpStatus.NOT_FOUND));

        if (this.repository.existeConflitoNoAgendamento(record.data(), calcHoras(record.data(), record.duracao()), record.mesa().numero(), agendamento.getId()))
            throw new AgendamentoException("O tempo de agendamento gera conflito com os demais agendamentos", HttpStatus.CONFLICT);

        agendamento.setData(record.data());
        agendamento.setDuracao(record.duracao());
        agendamento.setMesa(mesa);

        AgendamentoEntity agendamentoAtualizado = this.repository.save(agendamento);

        return new AgendamentoResponseRecord(agendamentoAtualizado);
    }

    public List<AgendamentoResponseRecord> todosAgendamentos() {
        List<AgendamentoEntity> agendamentos = this.repository.findAll();

        if (agendamentos.isEmpty())
            throw new AgendamentoException("Nenhum Agendamento encontrado", HttpStatus.NOT_FOUND);

        return agendamentos.stream().map(AgendamentoResponseRecord::new).toList();
    }

    public AgendamentoResponseRecord agendamentoId(Long id) {
        AgendamentoEntity agendamento = this.repository.findById(id).orElseThrow(() -> new AgendamentoException("Nenhum agendamento encontrado", HttpStatus.NOT_FOUND));

        return new AgendamentoResponseRecord(agendamento);
    }

    public List<AgendamentoResponseRecord> agendamentoDoDia(LocalDate data, Integer numero_mesa) {
        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.atTime(LocalTime.MAX);

        List<AgendamentoEntity> agendamentos = this.repository.findAgendamentosDoDia(inicio, fim, numero_mesa);

        if (agendamentos.isEmpty())
            throw new AgendamentoException("Nenhum agendamento na data " + data + " para a mesa: " + numero_mesa, HttpStatus.NOT_FOUND);

        return agendamentos.stream().map(AgendamentoResponseRecord::new).toList();
    }

    private LocalDateTime calcHoras(LocalDateTime data, int duracao) {
        final int intervalo = 15;
        return data.plusMinutes(duracao + intervalo);
    }
}