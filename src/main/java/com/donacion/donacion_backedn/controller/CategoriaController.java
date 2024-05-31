package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.Categoria;
import com.donacion.donacion_backedn.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;


    @GetMapping("{idCategoria}")
        public Categoria getCategoria(@PathVariable Integer idCategoria) {
        return categoriaService.getById(Long.valueOf(idCategoria));
    }

}
