package com.andalucia.datahub_backend.domain;

public class Territorio {
    private final Long id;
    private final String codigoTerritorio;
    private final String descripcionTerritorio;

    public Territorio (Long id, String codigoTerritorio, String descripcionTerritorio) {
        this.id = id;
        this.codigoTerritorio = codigoTerritorio;
        this.descripcionTerritorio = descripcionTerritorio;
    }

    public Territorio(String codigoTerritorio) {
        this(null, codigoTerritorio, null);
    }

    public Long getId() {

        return id;
    }

    public String getCodigoTerritorio() {

        return codigoTerritorio;
    }

    public String getDescripcionTerritorio() {

        return descripcionTerritorio;
    }
}





