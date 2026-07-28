package com.andalucia.datahub_backend.application;

import com.andalucia.datahub_backend.domain.RegistroEmpleoRepository;
import com.andalucia.datahub_backend.domain.SectorRepository;
import com.andalucia.datahub_backend.domain.TerritorioRepository;
import org.springframework.stereotype.Service;

@Service
public class IngestaMasivaUseCase {

    private final RegistroEmpleoRepository registroEmpleoRepository;

    public IngestaMasivaUseCase(RegistroEmpleoRepository registroEmpleoRepositor) {
        this.registroEmpleoRepository = registroEmpleoRepository;

    }

}
