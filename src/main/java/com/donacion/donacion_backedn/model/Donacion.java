package com.donacion.donacion_backedn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
@Setter
@Table
@Entity
public class Donacion {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToMany(mappedBy = "donacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoCarrito> productosDonacion;

    @ManyToOne
    @JoinColumn(name = "albergue_id")
    private Albergue albergue;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Usuario beneficiario;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Usuario voluntarioRecojo;


    private Boolean aceptado;


    private Boolean asignado;


    private Boolean recojo;

}
