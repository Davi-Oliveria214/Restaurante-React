package com.davi.restaurante.records.request;

import com.davi.restaurante.entity.MesaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record MesaRecord(@JsonProperty("numero_mesa") @NotNull Integer numero) {
    public MesaRecord(MesaEntity mesa) {
        this(mesa.getNumero());
    }
}
