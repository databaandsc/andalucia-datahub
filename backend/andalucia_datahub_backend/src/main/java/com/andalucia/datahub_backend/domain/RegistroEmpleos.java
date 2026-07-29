package com.andalucia.datahub_backend.domain;

public class RegistroEmpleos {
    private final Long id;
    private final Territorio territorio;
    private final Sector sector;
    private final Integer anio;
    private final Integer trimestre;
    private final Integer puestos;

    public RegistroEmpleos(Long id,
                           Territorio territorio,
                           Sector sector,
                           Integer anio,
                           Integer trimestre,
                           Integer puestos) {

        if (trimestre == null || trimestre > 4) {
            throw new IllegalArgumentException("El trimestre debe ser un valor entre 1 y 4.");
        }

        if (puestos == null || puestos < 0) {
            throw new IllegalArgumentException("El número de puestos debe ser un valor positivo.");
        }

        this.id = id;
        this.territorio = territorio;
        this.sector = sector;
        this.anio = anio;
        this.trimestre = trimestre;
        this.puestos = puestos;
    }

    // Constructor preparado para recibir los 5 datos exactos del Controlador
    public RegistroEmpleos(Territorio territorio,
                           Sector sector,
                           Integer anio,
                           Integer trimestre,
                           Integer puestos) {

        if (trimestre == null || trimestre > 4) {
            throw new IllegalArgumentException("El trimestre debe ser un valor entre 1 y 4.");
        }

        if (puestos == null || puestos < 0) {
            throw new IllegalArgumentException("El número de puestos debe ser un valor positivo.");
        }

        this.id = null;
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

    public Integer getPuestos() {
        return puestos;
    }
}
