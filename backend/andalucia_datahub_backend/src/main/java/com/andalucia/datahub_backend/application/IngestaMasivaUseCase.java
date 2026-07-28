package com.andalucia.datahub_backend.application;

import com.andalucia.datahub_backend.domain.RegistroEmpleos;
import com.andalucia.datahub_backend.domain.RegistroEmpleoRepository;
import com.andalucia.datahub_backend.domain.Sector;
import com.andalucia.datahub_backend.domain.Territorio;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class IngestaMasivaUseCase {

    private final RegistroEmpleoRepository registroEmpleoRepository;

    public IngestaMasivaUseCase(RegistroEmpleoRepository registroEmpleoRepository) {
        this.registroEmpleoRepository = registroEmpleoRepository;
    }

    // --- EL MOTOR ETL ---
    public void procesarJsonIeca(String jsonCompleto) throws Exception {

        // 1. Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Convertimos el String gigante de texto en un Árbol navegable
        JsonNode rootNode = mapper.readTree(jsonCompleto);

        // 2. Entramos directamente a la raíz donde están los datos
        JsonNode dataArray = rootNode.path("data");

        // 3. Bucle para procesar fila a fila
        for (JsonNode fila : dataArray) {

            // FASE E: Extracción
            String codigoSectorRaw = fila.get(0).get("cod").get(0).asText();
            String tiempoCodigoRaw = fila.get(1).get("cod").get(0).asText();
            String codigoTerritorioRaw = fila.get(2).get("cod").get(0).asText();
            int puestos = fila.get(4).get("val").asInt();

            // FASE T: Transformación (Partimos "20261" -> Año 2026, Trimestre 1)
            int anio = Integer.parseInt(tiempoCodigoRaw.substring(0, 4));
            int trimestre = Integer.parseInt(tiempoCodigoRaw.substring(4));

            // FASE L: Carga (Creamos los objetos de Dominio puros)
            Territorio territorio = new Territorio(codigoTerritorioRaw);
            Sector sector = new Sector(codigoSectorRaw);

            RegistroEmpleos nuevoRegistro = new RegistroEmpleos(
                    territorio,
                    sector,
                    anio,
                    trimestre,
                    puestos
            );

            registroEmpleoRepository.guardar(nuevoRegistro);
        }
    }
}

