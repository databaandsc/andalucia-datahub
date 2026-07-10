package com.andalucia.datahub_backend.application;

import com.andalucia.datahub_backend.domain.RegistroEmpleoRepository;
import com.andalucia.datahub_backend.domain.RegistroEmpleos;
import org.springframework.stereotype.Service;


@Service
public class ImportarRegistrosUseCase {
    private final RegistroEmpleoRepository repository;

    public ImportarRegistrosUseCase(RegistroEmpleoRepository repository) {

        this.repository = repository;
    }

    public void importarRegistro (RegistroEmpleos nuevoRegistro){

        repository.guardar(nuevoRegistro);
    }
}
