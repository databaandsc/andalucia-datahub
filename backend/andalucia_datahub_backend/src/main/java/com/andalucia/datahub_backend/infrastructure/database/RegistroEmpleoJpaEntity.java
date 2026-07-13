package com.andalucia.datahub_backend.infrastructure.database;

import jakarta.persistence.*;

@Entity
@Table (name = "registro_empleos")

public class RegistroEmpleoJpaEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_territorio")
    private TerritorioJpaEntity territorio;

    @ManyToOne
    @JoinColumn(name = "id_sector")
    private SectorJpaEntity sector;

    @Column (name = "año")
    private Integer annio;

    @Column (name = "trimestre")
    private Integer trimestre;

    @Column (name = "puestos")
    private Integer puestos;

    public RegistroEmpleoJpaEntity() {}

    public RegistroEmpleoJpaEntity (Long id,
                                    TerritorioJpaEntity territorio,
                                    SectorJpaEntity sector,
                                    Integer annio,
                                    Integer trimestre,
                                    Integer puestos) {
        this.id = id;
        this.territorio = territorio;
        this.sector = sector;
        this.annio = annio;
        this.trimestre = trimestre;
        this.puestos = puestos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TerritorioJpaEntity getTerritorio() {
        return territorio;
    }

    public void setTerritorio(TerritorioJpaEntity territorio) {
        this.territorio = territorio;
    }

    public SectorJpaEntity getSector() {
        return sector;
    }

    public void setSector(SectorJpaEntity sector) {
        this.sector = sector;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
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
