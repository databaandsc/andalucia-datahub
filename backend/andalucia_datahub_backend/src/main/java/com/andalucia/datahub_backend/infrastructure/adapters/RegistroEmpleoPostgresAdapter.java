package com.andalucia.datahub_backend.infrastructure.adapters;

import com.andalucia.datahub_backend.domain.RegistroEmpleos;
import com.andalucia.datahub_backend.domain.RegistroEmpleoRepository;
import com.andalucia.datahub_backend.infrastructure.database.RegistroEmpleoJpaEntity;
import com.andalucia.datahub_backend.infrastructure.database.SectorJpaEntity;
import com.andalucia.datahub_backend.infrastructure.database.SpringDataRegistroEmpleoRepository;
import com.andalucia.datahub_backend.infrastructure.database.SpringDataSectorRepository;
import com.andalucia.datahub_backend.infrastructure.database.SpringDataTerritorioRepository;
import com.andalucia.datahub_backend.infrastructure.database.TerritorioJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistroEmpleoPostgresAdapter implements RegistroEmpleoRepository {

    private final SpringDataRegistroEmpleoRepository registroRepository;
    private final SpringDataTerritorioRepository territorioRepository;
    private final SpringDataSectorRepository sectorRepository;

    public RegistroEmpleoPostgresAdapter(
            SpringDataRegistroEmpleoRepository registroRepository,
            SpringDataTerritorioRepository territorioRepository,
            SpringDataSectorRepository sectorRepository) {
        this.registroRepository = registroRepository;
        this.territorioRepository = territorioRepository;
        this.sectorRepository = sectorRepository;
    }

    @Override
    public RegistroEmpleos guardar(RegistroEmpleos registroEmpleo) {

        // 1. BUSCAR EN LA BASE DE DATOS
        TerritorioJpaEntity territorioJpa = territorioRepository.findByCodigo(registroEmpleo.getTerritorio().getCodigoTerritorio());
        SectorJpaEntity sectorJpa = sectorRepository.findByCodigo(registroEmpleo.getSector().getCodigoSector());

        // 2. MAPEO:
        RegistroEmpleoJpaEntity registroJpa = new RegistroEmpleoJpaEntity();
        registroJpa.setTerritorio(territorioJpa);
        registroJpa.setSector(sectorJpa);
        registroJpa.setAnnio(registroEmpleo.getAnio());
        registroJpa.setTrimestre(registroEmpleo.getTrimestre());
        registroJpa.setPuestos(registroEmpleo.getPuestos());

        // 3. Guardar en la base de datos:
        RegistroEmpleoJpaEntity guardadoJpa = registroRepository.save(registroJpa);

        // 4. DEVOLVER AL DOMINIO:
        return registroEmpleo;
    }

    // --- MÉTODOS PENDIENTES DE IMPLEMENTAR ---

    @Override
    public List<RegistroEmpleos> buscarPorAnio(Integer anio) {
        return null;
    }

    @Override
    public List<RegistroEmpleos> buscarPorAnioTrimestre(Integer anio, Integer trimestre) {
        return null;
    }

    @Override
    public List<RegistroEmpleos> buscarPorTerritorio(String codigoTerritorio) {
        return null;
    }

    @Override
    public List<RegistroEmpleos> buscarPorSector(String codigoSector) {
        return null;
    }
}