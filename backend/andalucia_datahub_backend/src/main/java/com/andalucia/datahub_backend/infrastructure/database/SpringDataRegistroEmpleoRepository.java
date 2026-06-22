package com.andalucia.datahub_backend.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataRegistroEmpleoRepository extends JpaRepository<RegistroEmpleoJpaEntity, Long> {

    // Busca por año:
    // SELECT * FROM registro_empleos WHERE año = ?
    List<RegistroEmpleoJpaEntity> findByAnnio(Integer annio);

    // Busca por trimestre:
    // SQL: SELECT * FROM registro_empleos WHERE trimestre = ?
    List<RegistroEmpleoJpaEntity> findByTrimestre(Integer trimestre);

    // Busca Año Y Trimestre:
    // SQL: SELECT * FROM registro_empleos WHERE año = ? AND trimestre = ?
    List<RegistroEmpleoJpaEntity> findByAnnioTrimestre(Integer annio, Integer trimestre);

    // Busca los que tengan MÁS de X puestos de trabajo:
    // SQL: SELECT * FROM registro_empleos WHERE puestos > ?
    List<RegistroEmpleoJpaEntity> findByPuestosGreaterThan(Double puestosMinimos);
}