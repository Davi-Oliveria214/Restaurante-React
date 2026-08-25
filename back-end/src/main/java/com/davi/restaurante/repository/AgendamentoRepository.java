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
                    "  INNER JOIN mesa m ON a.mesa = m.numero_mesa " +
                    "  WHERE m.numero_mesa = :numeroMesa " +
                    "  AND (:id IS NULL OR a.id <> :id) " +
                    "  AND a.data_agendada < :fim " +
                    "  AND (a.data_agendada + (a.duracao || ' minutes')::interval) > :inicio" +
                    ")")
    boolean existeConflitoNoAgendamento(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("numeroMesa") Integer numeroMesa,
            @Param("id") Long id
    );

    @Query(value = "SELECT a.* " +
            "FROM agendamentos a " +
            "INNER JOIN mesa m ON a.mesa = m.numero_mesa " +
            "WHERE a.data_agendada BETWEEN :inicioDoDia AND :fimDoDia " +
            "AND m.numero_mesa = :numeroMesa",
            nativeQuery = true)
    List<AgendamentoEntity> findAgendamentosDoDia(
            @Param("inicioDoDia") LocalDateTime inicioDoDia,
            @Param("fimDoDia") LocalDateTime fimDoDia,
            @Param("numeroMesa") Integer numeroMesa
    );
}
