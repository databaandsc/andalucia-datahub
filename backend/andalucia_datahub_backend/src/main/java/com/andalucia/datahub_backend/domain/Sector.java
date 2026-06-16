package com.andalucia.datahub_backend.domain;

public class Sector {

    private final Long id;
    private final String CodigoSector;
    private final String DescripcionSector;

    public Sector(Long id, String CodigoSector, String DescripcionSector) {
        this.id = id;
        this.CodigoSector = CodigoSector;
        this.DescripcionSector = DescripcionSector;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoSector() {
        return CodigoSector;
    }

    public String getDescripcionSector() {
        return DescripcionSector;
    }
}
