package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.PratoEntity;

public record PratoResponseRecord(Long id, String nome, String descricao, Double preco) {
    public PratoResponseRecord(PratoEntity prato) {
        this(prato.getId(), prato.getNome(), prato.getDescricao(), prato.getPreco());
    }
}