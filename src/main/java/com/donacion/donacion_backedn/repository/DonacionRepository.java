package com.donacion.donacion_backedn.repository;


import com.donacion.donacion_backedn.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
    List<Donacion> findByAsignado(boolean asignado);

    List<Donacion> findByBeneficiarioId(Integer beneficiarioId);
}
