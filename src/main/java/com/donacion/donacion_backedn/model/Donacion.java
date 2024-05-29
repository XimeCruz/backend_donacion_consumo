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

    @OneToMany(mappedBy = "donacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoCarrito> productosDonacion = new ArrayList<>();

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


    public void addProductoCarrito(ProductoCarrito productoCarrito) {
        productosDonacion.add(productoCarrito);
        productoCarrito.setDonacion(this);
    }

    public void removeProductoCarrito(ProductoCarrito productoCarrito) {
        productosDonacion.remove(productoCarrito);
        productoCarrito.setDonacion(null);
    }

}
