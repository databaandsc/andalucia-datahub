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

    public TerritorioJpaEntity(Long id, String codigo, String descripcion) {
        this.id = id;
        this.codigoTerritorio = codigo;
        this.descripcionTerritorio = descripcion;
    }

    //  Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {

        return codigoTerritorio;
    }

    public void setCodigo(String codigo) {

        this.codigoTerritorio = codigo;
    }

    public String getDescripcion() {

        return descripcionTerritorio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionTerritorio = descripcion;
    }

}