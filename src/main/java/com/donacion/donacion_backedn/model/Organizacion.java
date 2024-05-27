package com.donacion.donacion_backedn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Table
@Entity
public class Organizacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String nombre_org;
    private String ubicacion;
    private String tipo_org;
    private String tipo_alimento;
    private String area_servicio;



}
