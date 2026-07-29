package com.andalucia.datahub_backend.infrastructure.database;

import jakarta.persistence.*;

@Entity
@Table(name = "sector")
public class SectorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_sector")
    private String codigoSector;

    @Column (name = "descripcion_sector")
    private String descripcionSector;

    //JPA
    public SectorJpaEntity() {}

    public SectorJpaEntity(Long id, String codigoSector, String descripcionSector) {
        this.id = id;
        this.codigoSector = codigoSector;
        this.descripcionSector = descripcionSector;
    }

    // Getters y Setters

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getCodigoSector() {

        return codigoSector;
    }

    public void setCodigoSector(String codigoSector) {

        this.codigoSector = codigoSector;
    }

    public String getDescripcionSector() {

        return descripcionSector;
    }

    public void setDescripcionSector(String descripcionSector) {

        this.descripcionSector = descripcionSector;
    }
}
