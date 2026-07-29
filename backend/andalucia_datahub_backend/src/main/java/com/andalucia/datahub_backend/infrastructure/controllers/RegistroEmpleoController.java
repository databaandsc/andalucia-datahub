package com.andalucia.datahub_backend.infrastructure.controllers;

import com.andalucia.datahub_backend.application.ImportarRegistrosUseCase;
import com.andalucia.datahub_backend.application.IngestaMasivaUseCase;
import com.andalucia.datahub_backend.domain.RegistroEmpleos;
import com.andalucia.datahub_backend.domain.Sector;
import com.andalucia.datahub_backend.domain.Territorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleos")
public class RegistroEmpleoController {
    //1. Declaramos la clases de application como atributos de la clase RegistroEmpleoController
    private final ImportarRegistrosUseCase importarRegistrosUseCase;
    private final IngestaMasivaUseCase ingestaMasivaUseCase;


    // 2. Creamos el constructor
    public RegistroEmpleoController(ImportarRegistrosUseCase importarRegistrosUseCase,
                                    IngestaMasivaUseCase ingestaMasivaUseCase) {
        this.importarRegistrosUseCase = importarRegistrosUseCase;
        this.ingestaMasivaUseCase = ingestaMasivaUseCase;
    }

    // 3. Establacemos la puerta de conexión a Internet
    @PostMapping("/importarRegistro")
    public ResponseEntity<String> importarDesdeJson(@RequestBody RegistroEmpleoDTO dto) {

        // 4. MAPEO:
        Territorio territorioOrigen = new Territorio(dto.getCodigoTerritorio());
        Sector sectorOrigen = new Sector(dto.getCodigoSector());

        RegistroEmpleos registroOrigen = new RegistroEmpleos(
                territorioOrigen,
                sectorOrigen,
                dto.getAnio(),
                dto.getTrimestre(),
                dto.getPuestos()
        );

        // 5. Importamos los registros
        importarRegistrosUseCase.importarRegistro(registroOrigen);

        // 6. Respuesta a Internet
        return ResponseEntity.ok("Registro importado con éxito en la base de datos");
    }

    @PostMapping("/importarMasivo")
    public ResponseEntity<String> importarDesdeJson(@RequestBody String jsonCompleto) {
        try {
            ingestaMasivaUseCase.procesarJsonIeca(jsonCompleto);

            return ResponseEntity.ok("Proceso ETL completado: Todos los registros han sido guardados con éxito");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar el JSON: " + e.getMessage());
        }
    }
}