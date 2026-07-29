package com.andalucia.datahub_backend.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataSectorRepository extends JpaRepository<SectorJpaEntity, Long> {

    SectorJpaEntity findByCodigoSector(String codigoSector);
}