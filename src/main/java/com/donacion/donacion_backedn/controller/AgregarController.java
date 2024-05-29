package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.model.ProductoStock;
import com.donacion.donacion_backedn.request.AñadirProductoRequest;
import com.donacion.donacion_backedn.service.ProductoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agregar")
public class AgregarController {


    @Autowired
    private ProductoStockService productoStockService;



    @PostMapping("/producto")
    public ResponseEntity<ProductoStock> agregarProducto(@RequestBody AñadirProductoRequest añadirProductoRequest) {
        return new ResponseEntity<>(productoStockService.guardarProducto(añadirProductoRequest), HttpStatusCode.valueOf(200));
    }


    @PostMapping("/notificar-verificacion")
    public ResponseEntity<Notificacion> agregarNotificacion(@PathVariable("idProducto") Integer idProducto, @PathVariable("idVoluntario") Integer idVoluntario) {
        return new ResponseEntity<>(productoStockService.cambiarVerificacion(idProducto,idVoluntario), HttpStatusCode.valueOf(200));
    }



}
