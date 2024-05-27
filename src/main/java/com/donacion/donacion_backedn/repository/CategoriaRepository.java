package com.donacion.donacion_backedn.repository;


import com.donacion.donacion_backedn.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
