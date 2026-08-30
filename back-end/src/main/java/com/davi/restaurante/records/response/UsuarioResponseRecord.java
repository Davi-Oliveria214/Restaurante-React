package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.AgendamentoEntity;
import com.davi.restaurante.entity.UsuarioEntity;

import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioResponseRecord(Long id, String nome, String email,
                                    Set<AgendamentoItemResponseRecord> agendamentos) {
    public UsuarioResponseRecord(UsuarioEntity user) {
        this(user.getId(), user.getNome(), user.getEmail(), responseRecord(user.getAgendamentos()));
    }

    private static Set<AgendamentoItemResponseRecord> responseRecord(Set<AgendamentoEntity> entity) {
        if (entity == null || entity.isEmpty()) return Set.of();

        return entity.stream().map(AgendamentoItemResponseRecord::new).collect(Collectors.toSet());
    }
}
