package com.donacion.donacion_backedn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
@Getter
@Setter
@Table
@Entity
public class Donacion {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToMany(mappedBy = "donacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoCarrito> productosDonacion = new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "albergue_id")
    private Albergue albergue;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Usuario beneficiario;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Usuario voluntarioRecojo;


    private Boolean aceptado = false;


    private Boolean asignado = false;


    private Boolean recojo = false;


    private Boolean entregado = false;


    private Boolean recibido = false;

}
