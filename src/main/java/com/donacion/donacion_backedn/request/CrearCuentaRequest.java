package com.donacion.donacion_backedn.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearCuentaRequest {

    private String nombre;

    private String email;

    private String contrasenia;
}
