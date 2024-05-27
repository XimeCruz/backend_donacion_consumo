package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Actividad;
import com.donacion.donacion_backedn.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<Actividad> obtenerActivdades(){
        return actividadService.findAll();
    }


}
