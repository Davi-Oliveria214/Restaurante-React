package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.MesaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record MesaResponseRecord(Long id, @JsonProperty("numero_mesa") Integer numero,
                                 @JsonProperty("criado_em") Instant criado) {
    public MesaResponseRecord(MesaEntity mesa) {
        this(mesa.getId(), mesa.getNumero(), mesa.getCriado());
    }
}
