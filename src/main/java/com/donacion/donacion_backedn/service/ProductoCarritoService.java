package com.donacion.donacion_backedn.service;


import com.donacion.donacion_backedn.model.*;
import com.donacion.donacion_backedn.repository.ProductoCarritoRepository;
import com.donacion.donacion_backedn.repository.ProductoStockRepository;
import com.donacion.donacion_backedn.request.ProductoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ProductoStockService productoStockService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlbergueService albergueService;
    @Autowired
    private DonacionService donacionService;

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

    public ProductoCarrito guardarProducto(ProductoRequest productoRequest) {
        ProductoCarrito productoCarrito = new ProductoCarrito();
        Usuario usuario = usuarioService.obtenerUsuarioPorId(Long.valueOf(productoRequest.getIdUsuario()));
        ProductoStock productoStock = productoStockService.getById(Long.valueOf(productoRequest.getIdProducto()));
        productoCarrito.setFechaDeAgregado(Date.valueOf(LocalDate.now()));
        productoCarrito.setBeneficiario(usuario);
        productoCarrito.setProductoStock(productoStock);
        productoCarrito.setCantidadSeleccionada(productoRequest.getCantidad());
        productoCarrito.setConfirmado(false);
        return productoCarritoRepository.save(productoCarrito);
    }

    public void eliminarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.delete(productoCarrito);
    }


    public void actualizarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.save(productoCarrito);
    }


    public List<ProductoCarrito> getProdcutosPorEstado(Boolean estado) {
        return productoCarritoRepository.findByConfirmado(estado);
    }


    public Donacion confirmarPedido(Long idUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
        List<ProductoCarrito> productoCarritos = productoCarritoRepository.findByUsuario(usuario);
        for (ProductoCarrito productoCarrito : productoCarritos) {
            productoCarrito.setConfirmado(true);
            productoCarritoRepository.save(productoCarrito);
        }
        productoCarritoRepository.saveAll(productoCarritos);
        Donacion donacion = new Donacion();
        Albergue albergue = albergueService.findByBeneficiario(Math.toIntExact(idUsuario));
        donacion.setBeneficiario(usuario);
        donacion.setAlbergue(albergue);
        donacion.setProductosDonacion(productoCarritos);
        donacion.setAceptado(false);

        donacionService.saveDonacion(donacion);
        return donacion;
    }
}

