package com.andalucia.datahub_backend.domain;
import java.util.List;

public interface SectorRepository {
    // 1. Guardar un registro de Sector
    Sector guardar(Sector sector);

    // 2. Obtener todos los registros de sector por filtros
    // 2.1 Buscar por código de sector
    List <Sector> buscarPorSector(String codigoSector);
    // 2.2 Buscar por descripcion de sector
    List <Sector> buscarPorDescripcionSector(String descripcionSector);



}
