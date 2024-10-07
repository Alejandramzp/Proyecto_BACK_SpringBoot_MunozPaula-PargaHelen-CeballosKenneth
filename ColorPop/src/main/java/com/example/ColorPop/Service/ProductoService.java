package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Producto;
import com.example.ColorPop.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id){
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }

    public Producto updateProducto(Long id, Producto productoDetails){
        Producto producto = productoRepository.findById(id).orElseThrow();

        producto.setCodigo_producto(productoDetails.getCodigo_producto());
        producto.setNombre(productoDetails.getNombre());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setCantidad_disponible(productoDetails.getCantidad_disponible());

        return productoRepository.save(producto);
    }
}
