package com.donacion.donacion_backedn.service;

import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.repository.DonacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;
    @Autowired
    private NotificacionService notificacionService;

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

    public Donacion actualizarEstadoDonacion(Integer idDonacion) {
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
}
