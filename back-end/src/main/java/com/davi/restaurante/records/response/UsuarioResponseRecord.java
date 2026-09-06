package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.AgendamentoEntity;
import com.davi.restaurante.entity.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioResponseRecord(Long id, String nome, String email, @JsonProperty("criado_em") Instant criado,
                                    Set<AgendamentoItemResponseRecord> agendamentos) {
    public UsuarioResponseRecord(UsuarioEntity user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getCriado(), responseRecord(user.getAgendamentos()));
    }

    private static Set<AgendamentoItemResponseRecord> responseRecord(Set<AgendamentoEntity> entity) {
        if (entity == null || entity.isEmpty()) return Set.of();

        return entity.stream().map(AgendamentoItemResponseRecord::new).collect(Collectors.toSet());
    }
}
