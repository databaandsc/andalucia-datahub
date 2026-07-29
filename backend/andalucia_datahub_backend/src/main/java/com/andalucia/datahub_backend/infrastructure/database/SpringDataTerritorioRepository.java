package com.andalucia.datahub_backend.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataTerritorioRepository extends JpaRepository<TerritorioJpaEntity, Long> {

    // Buscar el territorio por su código exacto
    TerritorioJpaEntity findByCodigoTerritorio(String codigoTerritorio);
}
