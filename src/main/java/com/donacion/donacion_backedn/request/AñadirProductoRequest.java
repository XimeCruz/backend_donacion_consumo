package com.donacion.donacion_backedn.request;

import com.donacion.donacion_backedn.model.Categoria;
import com.donacion.donacion_backedn.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AñadirProductoRequest {

    private String nombre;

    private String descripcion;

    private Integer idCategoria;

    private Integer unidadesDisponibles;

    private Date fechaDeVencimiento;

    private String imagen;

    private Integer idDonante;


}
