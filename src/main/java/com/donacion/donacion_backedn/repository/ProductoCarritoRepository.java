package com.donacion.donacion_backedn.repository;


import com.donacion.donacion_backedn.model.ProductoCarrito;
import com.donacion.donacion_backedn.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoCarritoRepository extends JpaRepository<ProductoCarrito,Long> {

   // List<ProductoCarrito> findByBeneficiario(Usuario beneficiario);

    List<ProductoCarrito> findByConfirmado(Boolean confirmado);

    List<ProductoCarrito> findByUsuario(Usuario usuario);

}
