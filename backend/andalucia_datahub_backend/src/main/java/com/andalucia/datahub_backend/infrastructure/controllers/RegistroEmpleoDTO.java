package com.andalucia.datahub_backend.infrastructure.controllers;

public class RegistroEmpleoDTO {

    private String codigoTerritorio;
    private String codigoSector;
    private Integer anio;
    private Integer trimestre;
    private Integer puestos;

    public RegistroEmpleoDTO() {
    }

    // Getters y Setters
    public String getCodigoTerritorio() {
        return codigoTerritorio;
    }
    public void setCodigoTerritorio(String codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }

    public String getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(String codigoSector) {
        this.codigoSector = codigoSector;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public Integer getPuestos() {
        return puestos;
    }

    public void setPuestos(Integer puestos) {
        this.puestos = puestos;
    }

}