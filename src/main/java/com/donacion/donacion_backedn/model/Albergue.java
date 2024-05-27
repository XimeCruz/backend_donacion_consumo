package com.donacion.donacion_backedn.model;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "albergue")
@NoArgsConstructor
@AllArgsConstructor
public class Albergue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private Integer beneficiarioId;
    private String telefono;
    private String email;
    private String imagen;
    private double latitud;
    private double longitud;
    private Integer capacidad;
    @Column(length = 4000)
    private String descripcion;
}
