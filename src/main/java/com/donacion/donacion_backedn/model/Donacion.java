package com.donacion.donacion_backedn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
@Table
@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoCarrito productoCarrito;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Usuario beneficiario;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Usuario voluntarioRecojo;

}
