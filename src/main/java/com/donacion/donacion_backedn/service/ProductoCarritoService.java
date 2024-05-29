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
        productoCarrito.setFechaDeAgregado(Date.valueOf(LocalDate.now()));
        productoCarrito.setBeneficiarioId(productoRequest.getIdUsuario());
        productoCarrito.setCantidadSeleccionada(productoRequest.getCantidad());
        productoCarrito.setConfirmado(false);
        productoCarrito.setProductoId(productoRequest.getIdProducto());
        return productoCarritoRepository.save(productoCarrito);
    }

    public void eliminarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.delete(productoCarrito);
    }


    public void actualizarProducto(ProductoCarrito productoCarrito) {
        productoCarritoRepository.save(productoCarrito);
    }


    public List<ProductoCarrito> getProdcutosPorEstado(boolean estado, Long idBeneficiario) {
        return productoCarritoRepository.findByConfirmadoAndAndBeneficiarioId(estado, Long.valueOf(idBeneficiario));
    }


    public Donacion confirmarPedido(Long idUsuario) {

        List<ProductoCarrito> productoCarritos = productoCarritoRepository.findByConfirmadoAndAndBeneficiarioId(false, Long.valueOf(idUsuario));
        Donacion donacion = new Donacion();
        donacionService.saveDonacion(donacion);
        if(productoCarritos != null && !productoCarritos.isEmpty()){
            for (ProductoCarrito productoCarrito : productoCarritos) {
                System.out.println(productoCarrito);
                productoCarrito.setDonacion(donacion);
                productoCarrito.setConfirmado(true);
                donacion.addProductoCarrito(productoCarrito);
                productoCarritoRepository.save(productoCarrito);
            }
            //productoCarritoRepository.saveAll(productoCarritos);
            Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
            Albergue albergue = albergueService.findByBeneficiario(Math.toIntExact(idUsuario));
            donacion.setBeneficiario(usuario);
            donacion.setAlbergue(albergue);
            donacion.setAceptado(false);
            donacion.setAsignado(false);
            donacion.setRecojo(false);
            donacionService.saveDonacion(donacion);

            donacion.setProductosDonacion(productoCarritos);
            donacionService.saveDonacion(donacion);
        }

        return donacion;
    }
}

