package com.donacion.donacion_backedn.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@ToString
@Entity
@Table(name = "producto_carrito")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCarrito {

	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "cantidad seleccionada")
	private Integer cantidadSeleccionada;
	
	@Column(name = "fecha de agregado")
	private Date fechaDeAgregado;

	private Integer productoId;

	private Boolean confirmado;

	@ManyToOne
    @JoinColumn(name = "donacion_id")
    private Donacion donacion;

	private Integer beneficiarioId;

	
	
	
}
