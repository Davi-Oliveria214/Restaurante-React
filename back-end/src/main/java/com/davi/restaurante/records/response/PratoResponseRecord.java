package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.PratoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record PratoResponseRecord(Long id, String nome, String descricao, Double preco,
                                  @JsonProperty("criado_em") Instant criado) {
    public PratoResponseRecord(PratoEntity prato) {
        this(prato.getId(), prato.getNome(), prato.getDescricao(), prato.getPreco(), prato.getCriado());
    }
}