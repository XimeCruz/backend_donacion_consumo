package com.donacion.donacion_backedn.service;


import com.donacion.donacion_backedn.model.ProductoCarrito;
import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.repository.ProductoCarritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoCarritoService {


    @Autowired
    private ProductoCarritoRepository productoCarritoRepository;

    @Autowired
    private ClienteService clienteServices;

    public ProductoCarrito getById(Long id) {

        return productoCarritoRepository
                .findById(id)
                .orElse(null);
    }

    public List<ProductoCarrito> getProductos() {
        List<ProductoCarrito> productoCarritos = productoCarritoRepository.findAll();
        if (productoCarritos != null && !productoCarritos.isEmpty()) {
            return productoCarritos;
        } else if (productoCarritos != null && productoCarritos.isEmpty()) {
            return null;
        } else {
            return null;
        }
    }

    public void guardarProducto(ProductoCarrito productoCarrito) {
         //public void guardarProducto(ProductoCarrito productoCarrito, Authentication authentication) {

        //Usuario beneficiario=clienteServices.GetbyEmail(authentication.getName());
        Usuario beneficiario=clienteServices.GetbyEmail("Admin@gmail.com");
        productoCarrito.setFechaDeAgregado(Date.valueOf(LocalDate.now()));
        productoCarrito.setId(beneficiario.getId());
        productoCarritoRepository.save(productoCarrito);
    }

    public void eliminarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.delete(productoCarrito);
    }


    public void actualizarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.save(productoCarrito);
    }





}
