package com.andalucia.datahub_backend.domain;
import java.util.List;

public interface TerritorioRepository {
    // 1. Guardar un registro de Territorio
    Territorio guardar(Territorio territorio);

    // 2. Obtener todos los registros de territorio por filtros
    // 2.1 Buscar por código de territorio
    List <Territorio> buscarPorTerritorio(String codigoTerritorio);
    // 2.2 Buscar por descripcion de territorio
    List <Territorio> buscarPorDescripcionTerritorio(String descripcionTerritorio);
}
