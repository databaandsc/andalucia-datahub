package com.andalucia.datahub_backend.domain;
import java.util.List;

public interface RegistroEmpleoRepository {
    // Contrato 1. Guardar un registro nuevo de empleo
    RegistroEmpleos guardar(RegistroEmpleos registroEmpleos);

    // Contrato 2. Obtener todos los registros de empleo por filtros
    // 2.1 Buscar por año
    List<RegistroEmpleos> buscarPorAnio(Integer anio);
    // 2.2 Buscar por año y trimestre
    List<RegistroEmpleos> buscarPorAnioTrimestre(Integer anio,Integer trimestre);
    // 2.3 Buscar por territorio
    List<RegistroEmpleos> buscarPorTerritorio(String codigoTerritorio);
    // 2.4 Buscar por sector
    List<RegistroEmpleos> buscarPorSector(String codigoSector);
}
