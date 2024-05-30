package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.model.ProductoCarrito;
import com.donacion.donacion_backedn.request.ProductoRequest;
import com.donacion.donacion_backedn.response.DonacionResponse;
import com.donacion.donacion_backedn.response.NotificacionResponse;
import com.donacion.donacion_backedn.service.DonacionService;
import com.donacion.donacion_backedn.service.NotificacionService;
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
    @Autowired
    private NotificacionService notificacionService;

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
    public ResponseEntity<List<Notificacion>> verNotificaciones() {
        List<Notificacion> notificacionList = notificacionService.obtenerNotificaciones();
        return new ResponseEntity<>(notificacionList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/ver-info-noti-donacion/{idNotificacion}")
    public ResponseEntity<NotificacionResponse> obtenerDatosDNotificacion(@PathVariable("idNotificacion") Long idNotificacion) {
        return new ResponseEntity<>(notificacionService.obtenerInformacionNotificacion(idNotificacion), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/aceptar-recojo/{idNotificacion}/{idUsuario}")
    public ResponseEntity<Notificacion> aceptarRecojo(@PathVariable("idNotificacion") Integer idNotificacion,
                                            @PathVariable("idUsuario") Integer idUsuario) {
        return new ResponseEntity<>(notificacionService.actualizarEstadoNotificacion(idNotificacion, idUsuario), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/actualizar-entrega/{idNotificacion}/{idUsuario}")
    public ResponseEntity<Donacion> actualizarEntrega(@PathVariable("idNotificacion") Integer idNotificacion,
                                            @PathVariable("idUsuario") Integer idUsuario) {
        NotificacionResponse notificacion = notificacionService.obtenerInformacionNotificacion(Long.valueOf(idNotificacion));

        return new ResponseEntity<>(donacionService.actualizarEntrega(notificacion,idUsuario), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/actualizar-recibido/{idNotificacion}/{idUsuario}")
    public ResponseEntity<Donacion> actualizarRecibo(@PathVariable("idNotificacion") Integer idNotificacion,
                                            @PathVariable("idUsuario") Integer idUsuario) {
        NotificacionResponse notificacion = notificacionService.obtenerInformacionNotificacion(Long.valueOf(idNotificacion));
        return new ResponseEntity<>(donacionService.actualizarRecibido(notificacion,idUsuario), HttpStatusCode.valueOf(200));
    }

}
