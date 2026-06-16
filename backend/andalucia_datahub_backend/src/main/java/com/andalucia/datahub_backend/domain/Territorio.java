package com.andalucia.datahub_backend.domain;

public class Territorio {
    private final Long id;
    private final String codigoTerritorio;
    private final String descripcionTerritorio;

    public Territorio (Long id, String codigo_territorio, String descripcion_territorio) {
        this.id = id;
        this.codigoTerritorio = codigo_territorio;
        this.descripcionTerritorio = descripcion_territorio;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo_territorio() {
        return codigoTerritorio;
    }

    public String getDescripcion_territorio() {
        return descripcionTerritorio;
    }
}





