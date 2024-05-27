package com.donacion.donacion_backedn.repository;

import com.donacion.donacion_backedn.model.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
}
