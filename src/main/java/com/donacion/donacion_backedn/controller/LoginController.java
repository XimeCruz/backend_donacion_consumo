package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.request.CrearCuentaRequest;
import com.donacion.donacion_backedn.request.LoginRequest;
import com.donacion.donacion_backedn.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuario")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest request) {

        Usuario usuario = usuarioService.obtnerUsuarioPorEmail(request.getEmail());

        if (usuario!= null) {
            if(usuarioService.verificarCredenciales(request, usuario)){
                return ResponseEntity.ok(usuario);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear-cuenta")
    public ResponseEntity<Usuario> crearCuenta(@RequestBody CrearCuentaRequest crearCuentaRequest) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(crearCuentaRequest), HttpStatus.CREATED);
    }

}
