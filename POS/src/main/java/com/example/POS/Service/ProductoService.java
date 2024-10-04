package com.example.POS.Service;

import com.example.POS.Model.ProductosModel;
import com.example.POS.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener
    public List<ProductosModel> getAllProducto(){
        return productoRepository.findAll();
    }

    // Obtener  por ID
    public Optional<ProductosModel> getProductoById(long id){
        return productoRepository.findById(id);
    }

    // Guardar
    public ProductosModel saveProduto (ProductosModel Producto){
        return productoRepository.save(Producto);
    }

    // Actualizar
    public ProductosModel actualizarProducto(Long id, ProductosModel productoDetalles) {
        ProductosModel producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setCodigo_producto(productoDetalles.getCodigo_producto());
        producto.setNombre(productoDetalles.getNombre());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setPrecio_unitario(productoDetalles.getPrecio_unitario());
        producto.setCantidad_disponible(productoDetalles.getCantidad_disponible());
        producto.setEstado(productoDetalles.getEstado());
        return productoRepository.save(producto);
    }

    // Eliminar
    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}