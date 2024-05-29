package com.donacion.donacion_backedn.service;
import com.donacion.donacion_backedn.model.Notificacion;
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


    public void guardarNotificacion(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }
}
