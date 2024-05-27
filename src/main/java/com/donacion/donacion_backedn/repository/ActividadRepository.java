package com.donacion.donacion_backedn.repository;

import com.donacion.donacion_backedn.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
