package com.donacion.donacion_backedn.service;

import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.model.ProductoStock;
import com.donacion.donacion_backedn.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionService {


    @Autowired
    private NotificacionRepository notificacionRepository;


    @Autowired
    private ProductoStockService productoStockService;


    public void enviarNotificacion(String mensaje) {

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(mensaje);
        notificacionRepository.save(notificacion);
    }

//    public void generarNotificacionesPorVencimiento() {
//        Date fechaLimite = LocalDate.now().plusWeeks(1);
//        List<Producto> productos = productoRepository.findByFechaVencBefore(fechaLimite);
//        for (Producto producto : productos) {
//            String mensaje = "El producto " + producto.getNombre() + " vencerá pronto.";
//            Notificacion notificacion = new Notificacion();
//            notificacion.setMensaje(mensaje);
//            notificacion.setProducto(producto);
//            notificacionRepository.save(notificacion);
//        }
//    }


    public List<ProductoStock> obtenerProductosProximosAVencer() {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Calcular la fecha dentro de una semana
        long unaSemanaEnMillis = 7 * 24 * 60 * 60 * 1000; // 7 días en milisegundos
        Date fechaProximaSemana = new Date(fechaActual.getTime() + unaSemanaEnMillis);

        // Consultar la base de datos para encontrar los productos que vencen dentro de esa semana
        List<ProductoStock> productosProximosAVencer = productoStockService.findByFechaVencBetween(fechaActual,fechaProximaSemana);

        if(!productosProximosAVencer.isEmpty()){
            return productosProximosAVencer;
        }
        return null;
    }

    public void guardarNotificacion(Notificacion notification) {
        notificacionRepository.save(notification);
    }

    public List<Notificacion> obtenerNotificaciones() {
        return notificacionRepository.findAll();
    }
}
