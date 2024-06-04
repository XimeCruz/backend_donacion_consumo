package com.donacion.donacion_backedn.response;

import com.donacion.donacion_backedn.model.Albergue;
import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.ProductoCarrito;
import com.donacion.donacion_backedn.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DonacionResponse {

    private Donacion donacion;

//    private Albergue albergue;
//
//    private Usuario beneficiario;

    private Usuario voluntarioRecojo;

    private List<ProductoCarrito> productosDonacion = new ArrayList<>();

}
