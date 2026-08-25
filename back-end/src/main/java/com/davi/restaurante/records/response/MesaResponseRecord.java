package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.MesaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public record MesaResponseRecord(Long id, @JsonProperty("numero_mesa") Integer numero) {
    public MesaResponseRecord(MesaEntity mesa) {
        this(mesa.getId(), mesa.getNumero());
    }
}
