package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.ProductoCarrito;
import com.donacion.donacion_backedn.request.ProductoRequest;
import com.donacion.donacion_backedn.response.DonacionResponse;
import com.donacion.donacion_backedn.service.DonacionService;
import com.donacion.donacion_backedn.service.ProductoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    public ProductoCarritoService productoCarritoService;
    @Autowired
    public DonacionService donacionService;

    @PostMapping("/anadir-producto")
    public ResponseEntity<ProductoCarrito> añadirProducto(@RequestBody ProductoRequest productoRequest) {
        ProductoCarrito productoCarrito = productoCarritoService.guardarProducto(productoRequest);
        return new ResponseEntity<>(productoCarrito, HttpStatusCode.valueOf(200));

    }

    @GetMapping("/carrito-donacion/{idBeneficiario}")
    public ResponseEntity<List<ProductoCarrito>> carritoDonacion(@PathVariable Long idBeneficiario) {
        List<ProductoCarrito> productoCarritoList = productoCarritoService.getProdcutosPorEstado(false,idBeneficiario);
        return new ResponseEntity<>(productoCarritoList, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/carrito-confirmar/{idUsuario}")
    public ResponseEntity<Donacion> carritoConfirmar(@PathVariable("idUsuario") Long idUsuario) {
        return new ResponseEntity<>(productoCarritoService.confirmarPedido(idUsuario), HttpStatusCode.valueOf(200));
    }

    //ver productos confirmados detalle de donacion
    @GetMapping("/lista-donacion/{idBeneficiario}")
    public ResponseEntity<List<ProductoCarrito>> carritoListaDonacion(@PathVariable Long idBeneficiario) {
        List<ProductoCarrito> productoCarritoList = productoCarritoService.getProdcutosPorEstado(true,idBeneficiario);
        return new ResponseEntity<>(productoCarritoList, HttpStatusCode.valueOf(200));
    }

    //en la web ver la lista de donacion y tambien ver por id

    //lista donaciones pedidas
    @GetMapping("/lista-donacion-pedida")
    public ResponseEntity<List<Donacion>> listaDonacionesPedidas() {
        return new ResponseEntity<>(donacionService.getAllDonacions(),HttpStatusCode.valueOf(200));
    }

    //obtener detalle de donaciones
    @GetMapping("/lista-info-donacion/{idDonacion}")
    public ResponseEntity<DonacionResponse> donacionPedida(@PathVariable Long idDonacion) {
        return new ResponseEntity<>(productoCarritoService.obtenerInformacionDonacion(idDonacion),HttpStatusCode.valueOf(200));
    }

    //en la web ver la lista de donacion y tambien ver por id
    //cambiar la propiedad aceptado a true en administrador
    @PostMapping("/aceptar/{idDonacion}")
    public ResponseEntity<Donacion> donacionAceptada(@PathVariable Long idDonacion) {
        return new ResponseEntity<>(donacionService.actualizarEstadoDonacion(idDonacion),HttpStatusCode.valueOf(200));
    }


    //en voluntario al momento de ser acptado ver en notificaciones
    @GetMapping("/ver-notificaciones")
    public ResponseEntity<List<Donacion>> verNotificaciones() {
        List<Donacion> donacionList = donacionService.obtenerDonacionSinAsignar();
        return new ResponseEntity<>(donacionList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/obtener-datos/{idDonacion}")
    public ResponseEntity<Donacion> obtenerDatosDonacion(@PathVariable("idDonacion") Integer idDonacion) {
        return new ResponseEntity<>(donacionService.getDonacionById(idDonacion), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/aceptar-recojo/{idDonacion}")
    public ResponseEntity<Donacion> aceptarRecojo(@PathVariable("idDonacion") Long idDonacion) {
        return new ResponseEntity<>(donacionService.actualizarEstadoDonacion(idDonacion), HttpStatusCode.valueOf(200));
    }

    /*@PostMapping("/actualizar-recojo/{idDonacion}")
    public ResponseEntity<Donacion> actualizarRecojo(@PathVariable("idDonacion") Integer idDonacion) {
        return new ResponseEntity<>(donacionService.actualizarRecojo(idDonacion), HttpStatusCode.valueOf(200));
    }*/


}
