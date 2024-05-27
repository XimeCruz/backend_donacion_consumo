package com.donacion.donacion_backedn.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


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
	
	
	/**
	 * identifica el producto de la tienda asociado a un producto agregado al carrito.
	 */
	@OneToOne()
	@JoinColumn(name = "IdProducto_Stock")
	private ProductoStock productoStock;

	
	
	
}
