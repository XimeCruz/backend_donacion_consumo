package com.donacion.donacion_backedn.response;

import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.ProductoCarrito;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionResponse {

    private String mensaje;

    private Donacion donacion;

    private ProductoCarrito producto;

    private boolean visto;


}
