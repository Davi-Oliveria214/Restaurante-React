package com.davi.restaurante.records.request;

import com.davi.restaurante.entity.AgendamentoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRecord(@NotNull Long userId, @NotNull LocalDateTime data, @NotNull int duracao,
                                @JsonProperty("mesa") @NotNull MesaRecord mesa) {

    public AgendamentoRecord(Long userId, AgendamentoEntity a) {
        this(userId, a.getData(), a.getDuracao(), new MesaRecord(a.getMesa().getNumero()));
    }
}