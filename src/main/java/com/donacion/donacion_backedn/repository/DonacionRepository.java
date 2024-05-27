package com.donacion.donacion_backedn.repository;


import com.donacion.donacion_backedn.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {
}
