package com.donacion.donacion_backedn.service;
import com.donacion.donacion_backedn.model.Donacion;
import com.donacion.donacion_backedn.model.Notificacion;
import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.repository.NotificacionRepository;
import com.donacion.donacion_backedn.response.NotificacionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionService {


    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    @Lazy
    private DonacionService donacionService;

    @Autowired
    private UsuarioService usuarioService;


    public void guardarNotificacion(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    public List<Notificacion> obtenerNotificaciones() {
        return notificacionRepository.findAll();
    }

    public NotificacionResponse obtenerInformacionNotificacion(Long idNotificacion) {
        Notificacion notificacion = notificacionRepository.findById(idNotificacion).orElse(null);
        NotificacionResponse notificacionResponse = new NotificacionResponse();
        notificacionResponse.setDonacion(donacionService.getDonacionById(notificacion.getIdDonacion()));
        notificacion.setVisto(true);
        notificacionRepository.save(notificacion);
        notificacionResponse.setMensaje(notificacion.getMensaje());
        return notificacionResponse;
    }

    public Notificacion actualizarEstadoNotificacion(Integer idNotificacion, Integer idUsuario) {
        Notificacion notificacion = notificacionRepository.getById(idNotificacion.longValue());
        Donacion donacion = donacionService.getDonacionById(notificacion.getIdDonacion());
        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario.longValue());
        donacion.setAsignado(true);
        donacion.setVoluntarioRecojo(usuario);
        donacionService.saveDonacion(donacion);
        Notificacion notificacion2 = new Notificacion();
        notificacion2.setMensaje("El voluntario "+ donacion.getVoluntarioRecojo().getNombre() + " ya ha aceptado llevar la donacion, al albergue "+ donacion.getAlbergue().getNombre());
        notificacion2.setIdDonacion(notificacion.getIdDonacion());
        guardarNotificacion(notificacion2);
        return notificacion2;
    }
}
