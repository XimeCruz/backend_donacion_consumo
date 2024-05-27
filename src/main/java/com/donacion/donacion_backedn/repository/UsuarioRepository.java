package com.donacion.donacion_backedn.repository;

import com.donacion.donacion_backedn.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByCorreoElectronico(String email);

    public boolean existsByCorreoElectronico(String email);

    public Usuario findUsuarioByNombreUsuario(String nombreUsuario);



}
