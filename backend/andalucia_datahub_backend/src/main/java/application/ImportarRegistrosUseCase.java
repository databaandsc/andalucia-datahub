package application;

import com.andalucia.datahub_backend.domain.RegistroEmpleoRepository;
import com.andalucia.datahub_backend.domain.RegistroEmpleos;

public class ImportarRegistrosUseCase {
    private final RegistroEmpleoRepository repository;

    public ImportarRegistrosUseCase(RegistroEmpleoRepository repository) {
        this.repository = repository;
    }

    public void ejecutar (RegistroEmpleos nuevoRegistro){

        repository.guardar(nuevoRegistro);
    }
}
