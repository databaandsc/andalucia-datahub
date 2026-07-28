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
        TerritorioJpaEntity territorioJpa = territorioRepository.findByCodigoTerritorio(registroEmpleo.getTerritorio().getCodigoTerritorio());
        SectorJpaEntity sectorJpa = sectorRepository.findByCodigoSector(registroEmpleo.getSector().getCodigoSector());

        if (territorioJpa == null) {
            territorioJpa = new TerritorioJpaEntity();
            territorioJpa.setCodigoTerritorio(registroEmpleo.getTerritorio().getCodigoTerritorio());
            territorioJpa.setDescripcionTerritorio(registroEmpleo.getTerritorio().getDescripcionTerritorio());
            territorioJpa = territorioRepository.save(territorioJpa);
        }

        if (sectorJpa == null) {
            sectorJpa = new SectorJpaEntity();
            sectorJpa.setCodigoSector(registroEmpleo.getSector().getCodigoSector());
            sectorJpa.setDescripcionSector(registroEmpleo.getSector().getDescripcionSector());
            sectorJpa = sectorRepository.save(sectorJpa);
        }

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
    public List<RegistroEmpleos> buscarPorAnio(Integer annio) {
        return null;
    }

    @Override
    public List<RegistroEmpleos> buscarPorAnioAndTrimestre(Integer annio, Integer trimestre) {
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