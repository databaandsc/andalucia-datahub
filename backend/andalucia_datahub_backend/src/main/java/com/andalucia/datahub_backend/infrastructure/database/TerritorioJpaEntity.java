package com.andalucia.datahub_backend.infrastructure.database;

import jakarta.persistence.*;

@Entity
@Table(name = "territorio")
public class TerritorioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_territorio")
    private String codigoTerritorio;

    @Column(name = "descripcion_territorio")
    private String descripcionTerritorio;

    // JPA
    public TerritorioJpaEntity() {}

    public TerritorioJpaEntity(Long id, String codigoTerritorio, String descripcionTerritorio) {
        this.id = id;
        this.codigoTerritorio = codigoTerritorio;
        this.descripcionTerritorio = descripcionTerritorio;
    }

    //  Getters y Setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCodigoTerritorio() {
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(String codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }

    public String getDescripcionTerritorio() {
        return descripcionTerritorio;
    }

    public void setDescripcionTerritorio(String descripcionTerritorio) {
        this.descripcionTerritorio = descripcionTerritorio;
    }

}