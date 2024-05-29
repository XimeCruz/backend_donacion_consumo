package com.donacion.donacion_backedn.controller;

import com.donacion.donacion_backedn.model.ProductoStock;
import com.donacion.donacion_backedn.service.ProductoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoStockService productoStockService;

    @GetMapping
    public List<ProductoStock> obtenerProductosStock(){
        return productoStockService.getProductoStocks();
    }


    @GetMapping("/{idProducto}")
    public ProductoStock obtenerProductoPorId(@PathVariable("idProducto") Long id){
        return productoStockService.getById(id);
    }

}
