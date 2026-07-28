package com.andalucia.datahub_backend.infrastructure.controllers;

import com.andalucia.datahub_backend.application.ImportarRegistrosUseCase;
import com.andalucia.datahub_backend.domain.RegistroEmpleos;
import com.andalucia.datahub_backend.domain.Sector;
import com.andalucia.datahub_backend.domain.Territorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleos")
public class RegistroEmpleoController {
    //1. Declaramos la clase ImportarRegistrosUseCase como atributo de la clase RegistroEmpleoController
    private final ImportarRegistrosUseCase importarRegistrosUseCase;

    // 2. Creamos el constructor
    public RegistroEmpleoController(ImportarRegistrosUseCase importarRegistrosUseCase) {
        this.importarRegistrosUseCase = importarRegistrosUseCase;
    }

    // 3. Establacemos la puerta de conexión a Internet
    @PostMapping("/importarRegistro")
    public ResponseEntity<String> importarDesdeJson(@RequestBody RegistroEmpleoDTO dto) {

        // 4. MAPEO: Convertir el DTO (Internet) al• (Dominio)
        // (Creamos objetos básicos de Territorio y Sector solo con sus códigos)
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
}