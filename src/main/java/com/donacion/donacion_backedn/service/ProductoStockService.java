package com.donacion.donacion_backedn.service;

import com.donacion.donacion_backedn.model.Categoria;
import com.donacion.donacion_backedn.model.ProductoStock;
import com.donacion.donacion_backedn.model.Usuario;
import com.donacion.donacion_backedn.repository.ProductoStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoStockService {

    @Autowired
    private ProductoStockRepository productoStockRepository;


    @Autowired
    private VendedorService vendedorServices;

    @Autowired
    private CategoriaService categoriaServices;

    @Autowired
    private UsuarioService usuarioService;

    public ProductoStock getById(Long id) {

        return productoStockRepository
                .findById(id)
                .orElse(null);
    }

    public List<ProductoStock> getProductoStocks() {
        return productoStockRepository.findAll();
    }

    public void guardarProducto(ProductoStock productoStock) {

        Usuario donante=vendedorServices.GetbyEmail("Admin@gmail.com");
        productoStock.setFechaDePublicacion(java.sql.Date.valueOf(LocalDate.now()));
        productoStock.setDonante(donante);
        productoStockRepository.save(productoStock);
    }

    public void eliminarProducto(Long id) {

        productoStockRepository.deleteById(id);
    }


    public void actualizarProducto(ProductoStock productoStock) {

        ProductoStock productoStockActualizar=productoStockRepository
                .findById(productoStock.getId())
                .get();

        Categoria categoria= categoriaServices
                .getById(productoStock
                        .getCategoria()
                        .getId());


        productoStockActualizar.setNombre(productoStock.getNombre());
        productoStockActualizar.setUnidadesDisponibles(productoStock.getUnidadesDisponibles());
        productoStockActualizar.setDescripcion(productoStock.getDescripcion());


        productoStockActualizar.setCategoria(categoria);

        productoStockRepository.save(productoStockActualizar);
    }


    public List<ProductoStock> porCategoria(Long id) {

        Categoria categoria= categoriaServices.getById(id);

        return productoStockRepository.findByCategoria(categoria);
    }




    public Page<ProductoStock> getProductos(Pageable pageable) {

        return productoStockRepository.findAll(pageable);
    }


    public List<ProductoStock> porFechaDepublicacion() {

        return productoStockRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaDePublicacion"));
    }


    public List<ProductoStock> porCantidadDisponible() {

        return productoStockRepository.findAll(Sort.by(Sort.Direction.DESC, "unidadesDisponibles"));
    }


    public List<ProductoStock> findByFechaVencBetween(Date fechaActual, Date fechaProximaSemana){
        return productoStockRepository.findByFechaDeVencimientoBetween(fechaActual,fechaProximaSemana);
    }

    // Método para confirmar estado del producto
    public void confirmarProducto(Long id) {
        ProductoStock producto = productoStockRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setConfirmado(true);
        productoStockRepository.save(producto);
    }

    public List<ProductoStock> findByDonante(Integer id){
        return productoStockRepository.findByDonante(usuarioService.obtenerUsuarioPorId(Long.valueOf(id)));
    }

}
