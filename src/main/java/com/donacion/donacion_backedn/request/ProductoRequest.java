package com.donacion.donacion_backedn.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequest {

    private Integer idProducto;

    private Integer cantidad;

    private Integer idUsuario;

}
