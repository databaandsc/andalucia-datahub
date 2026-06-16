package com.andalucia.datahub_backend.domain;

public class RegistroEmpleos {
    private final Long id;
    private final Territorio territorio;
    private final Sector sector;
    private final Integer anio;
    private final Integer trimestre;
    private final Double puestos;

    public RegistroEmpleos(Long id,
                           Territorio territorio,
                           Sector sector,
                           Integer anio,
                           Integer trimestre,
                           Double puestos) {
        this.id = id;
        this.territorio = territorio;
        this.sector = sector;
        this.anio = anio;
        this.trimestre = trimestre;
        this.puestos = puestos;
    }

    public Long getId() {
        return id;
    }

    public Territorio getTerritorio() {
        return territorio;
    }

    public Sector getSector() {
        return sector;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public Double getPuestos() {
        return puestos;
    }
}
