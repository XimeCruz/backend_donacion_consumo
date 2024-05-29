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

	@OneToOne()
	@JoinColumn(name = "IdProducto_Stock")
	private ProductoStock productoStock;

	@OneToOne()
	@JoinColumn(name = "idBeneficiario")
	private Usuario Beneficiario;

	private Boolean confirmado;

	
	
	
}
