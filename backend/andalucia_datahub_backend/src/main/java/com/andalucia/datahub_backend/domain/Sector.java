package com.andalucia.datahub_backend.domain;

public class Sector {

    private final Long id;
    private final String codigoSector;
    private final String descripcionSector;

    public Sector(Long id, String CodigoSector, String DescripcionSector) {
        this.id = id;
        this.codigoSector = CodigoSector;
        this.descripcionSector = DescripcionSector;
    }

    public Sector(String CodigoSector){
        this(null, CodigoSector, null);
    }

    public Long getId() {

        return id;
    }

    public String getCodigoSector() {

        return codigoSector;
    }

    public String getDescripcionSector() {

        return descripcionSector;
    }
}
