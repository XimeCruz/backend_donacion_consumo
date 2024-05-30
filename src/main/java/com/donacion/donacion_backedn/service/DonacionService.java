package com.donacion.donacion_backedn.service;

import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.repository.DonacionRepository;
import com.donacion.donacion_backedn.response.DonacionResponse;
import com.donacion.donacion_backedn.response.NotificacionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonacionService {

    @Autowired
    public DonacionRepository donacionRepository;

    @Autowired
    public NotificacionService notificacionService;

    @Autowired
    @Lazy
    public ProductoCarritoService productoCarritoService;

    // Método para obtener todas las Donacions
    public List<Donacion> getAllDonacions() {
        return donacionRepository.findAll();
    }

    // Método para obtener una Donacion por su ID
    public Donacion getDonacionById(Integer id) {
        return donacionRepository.findById(Long.valueOf(id)).orElse(null);
    }

    // Método para guardar una nueva Donacion
    public Donacion saveDonacion(Donacion Donacion) {
        return donacionRepository.save(Donacion);
    }

    // Método para actualizar una Donacion existente
    public Donacion updateDonacion(Long id, Donacion Donacion) {
        if (donacionRepository.existsById(id)) {
            Donacion.setId(id);
            return donacionRepository.save(Donacion);
        }
        return null;
    }

    // Método para eliminar una Donacion por su ID
    public void deleteDonacion(Long id) {
        donacionRepository.deleteById(id);
    }

    public List<Donacion> getDonacionsAsc() {
        return donacionRepository.findAll(Sort.by(Sort.Direction.ASC,"nombre"));
    }

    public List<Donacion> obtenerDonacionSinAsignar() {
        return donacionRepository.findByAsignado(false);
    }

    public Donacion actualizarEstadoDonacion(Long idDonacion) {
        Notificacion notificacion = new Notificacion();
        notificacion.setIdDonacion(Math.toIntExact(idDonacion));
        notificacion.setVisto(false);
        notificacion.setMensaje("Donacion en espera");
        notificacionService.guardarNotificacion(notificacion);
        Donacion donacion = donacionRepository.findById(Long.valueOf(idDonacion)).orElse(null);
        donacion.setAceptado(true);
        donacionRepository.save(donacion);
        return donacion;
    }

    public Donacion actualizarRecojo(Integer idDonacion) {
        Donacion donacion = donacionRepository.findById(Long.valueOf(idDonacion)).orElse(null);
        donacion.setRecojo(true);
        donacionRepository.save(donacion);
        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje("El voluntario "+ donacion.getVoluntarioRecojo().getNombre() + "ya ha llevado al albergue "+ donacion.getAlbergue().getNombre());
        notificacionService.guardarNotificacion(notificacion);
        return donacion;
    }

    public Donacion actualizarEntrega(NotificacionResponse notificacion, Integer idUsuario) {
        Donacion donacion = notificacion.getDonacion();
        donacion.setEntregado(true);
        donacionRepository.save(donacion);
        return donacion;
    }

    public Donacion actualizarRecibido(NotificacionResponse notificacion, Integer idUsuario) {
        Donacion donacion = notificacion.getDonacion();
        donacion.setRecibido(true);
        donacionRepository.save(donacion);
        return donacion;
    }
}
