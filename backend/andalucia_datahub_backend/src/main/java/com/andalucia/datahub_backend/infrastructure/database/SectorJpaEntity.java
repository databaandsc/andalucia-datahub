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

    public SectorJpaEntity(Long id, String codigo_sector, String descripcion_sector) {
        this.id = id;
        this.codigoSector = codigo_sector;
        this.descripcionSector = descripcion_sector;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_sector() {
        return codigoSector;
    }

    public void setCodigo_sector(String codigo_sector) {
        this.codigoSector = codigo_sector;
    }

    public String getDescripcion_sector() {
        return descripcionSector;
    }

    public void setDescripcion_sector(String descripcion_sector) {
        this.descripcionSector = descripcion_sector;
    }
}
