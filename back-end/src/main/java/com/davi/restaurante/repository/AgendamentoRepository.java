package com.davi.restaurante.repository;

import com.davi.restaurante.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

    @Query(nativeQuery = true, value =
            "SELECT EXISTS(" +
                    "  SELECT 1 FROM agendamentos a " +
                    "  INNER JOIN mesa m ON a.mesa_id = m.id " +
                    "  WHERE m.id = :mesaId " +
                    "  AND (:id IS NULL OR a.id <> :id) " +
                    "  AND a.data_agendada < :fim " +
                    "  AND (a.data_agendada + (a.duracao || ' minutes')::interval) > :inicio" +
                    ")")
    boolean existeConflitoNoAgendamento(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("mesaId") Long mesaId,
            @Param("id") Long id
    );

    @Query(value = "SELECT a.* " +
            "FROM agendamentos a " +
            "INNER JOIN mesa m ON a.mesa_id = m.id " +
            "WHERE a.data_agendada BETWEEN :inicioDoDia AND :fimDoDia " +
            "AND m.id = :mesaId AND a.usuario_id = :userId",
            nativeQuery = true)
    List<AgendamentoEntity> findAgendamentosDoDia(
            @Param("inicioDoDia") LocalDateTime inicioDoDia,
            @Param("fimDoDia") LocalDateTime fimDoDia,
            @Param("mesaId") Long mesaId,
            @Param("userId") Long id
    );

    List<AgendamentoEntity> findByUsuarioId(Long userId);
}