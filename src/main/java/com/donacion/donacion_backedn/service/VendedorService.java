package com.donacion.donacion_backedn.service;


import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendedorService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public void crearCuenta(Usuario vendedor) {

        usuarioRepository.save(vendedor);
    }

    public Boolean existsByEmail(String email) {

        return usuarioRepository.existsByCorreoElectronico(email);
    }


    public Usuario GetbyEmail(String email) {

        return usuarioRepository.findByCorreoElectronico(email);
    }


    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElseGet(null);
    }


}
