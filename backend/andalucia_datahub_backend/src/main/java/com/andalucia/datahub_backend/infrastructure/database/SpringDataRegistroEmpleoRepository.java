package com.andalucia.datahub_backend.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataRegistroEmpleoRepository extends JpaRepository<RegistroEmpleoJpaEntity, Long> {

    // Busca por año:
    // SELECT * FROM registro_empleos WHERE año = ?
    List<RegistroEmpleoJpaEntity> findByAnio(Integer anio);

    // Busca por trimestre:
    // SQL: SELECT * FROM registro_empleos WHERE trimestre = ?
    List<RegistroEmpleoJpaEntity> findByTrimestre(Integer trimestre);

    // Busca Año Y Trimestre:
    // SQL: SELECT * FROM registro_empleos WHERE año = ? AND trimestre = ?
    List<RegistroEmpleoJpaEntity> findByAnioAndTrimestre(Integer anio, Integer trimestre);

    // Busca los que tengan MÁS de X puestos de trabajo:
    // SQL: SELECT * FROM registro_empleos WHERE puestos > ?
    List<RegistroEmpleoJpaEntity> findByPuestosGreaterThan(Integer puestosMinimos);

    // Busca por código de Territorio (hace un JOIN con la tabla territorios automáticamente):
    // SQL: SELECT re.* FROM registro_empleos re JOIN territorio t ON re.id_territorio = t.id WHERE t.codigo_territorio = ?
    List<RegistroEmpleoJpaEntity> findByTerritorio_CodigoTerritorio(String codigo);

    // Busca por código de Sector (hace un JOIN con la tabla sectores automáticamente):
    // SQL: SELECT re.* FROM registro_empleos re JOIN sector s ON re.id_sector = s.id WHERE s.codigo_sector = ?
    List<RegistroEmpleoJpaEntity> findBySector_CodigoSector(String codigo);
}