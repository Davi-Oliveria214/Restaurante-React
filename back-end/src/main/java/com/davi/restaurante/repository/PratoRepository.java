package com.davi.restaurante.repository;

import com.davi.restaurante.entity.PratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PratoRepository extends JpaRepository<PratoEntity, Long> {
    Optional<PratoEntity> findByNome(String nome);
}