package com.donacion.donacion_backedn.service;


import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.repository.UsuarioRepository;
import com.donacion.donacion_backedn.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtnerUsuarioPorNombreUsuario (String nombre){
        return usuarioRepository.findUsuarioByNombreUsuario(nombre);
    }

    public Usuario obtnerUsuarioPorEmail(String email){
        return usuarioRepository.findByCorreoElectronico(email);
    }

    public boolean verificarCredenciales(LoginRequest request, Usuario usuario) {
        if((request.getContrasenia()).equals(usuario.getPassword())){
            return true;
        }
        return false;
    }
}
