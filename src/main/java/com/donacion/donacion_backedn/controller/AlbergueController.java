package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Albergue;
import com.donacion.donacion_backedn.service.AlbergueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albergues")
public class AlbergueController {

    @Autowired
    AlbergueService albergueService;


    @GetMapping
        public List<Albergue> getAllAlbergues() {
        return albergueService.getAlbergues();
    }

}
