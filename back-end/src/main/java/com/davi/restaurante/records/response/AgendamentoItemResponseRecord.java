package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.AgendamentoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record AgendamentoItemResponseRecord(Long id, LocalDateTime data, int duracao,
                                            @JsonProperty("mesa") MesaResponseRecord mesa) {
    public AgendamentoItemResponseRecord(AgendamentoEntity a) {
        this(a.getId(), a.getData(), a.getDuracao(), new MesaResponseRecord(a.getMesa()));
    }
}