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

    // obtener todos los productos

    public List<ProductosModel> getAllProducto(){
        return productoRepository.findAll();
    }

    // obteer producto por ID
    public Optional<ProductosModel> getProductoById(long id){
        return productoRepository.findById(id);
    }

    // Guardar Producto

    public ProductosModel saveProduto (ProductosModel Producto){
        return productoRepository.save(Producto);
    }

    // Actualizar Producto
    public ProductosModel actualizarProducto(Long id, ProductosModel productoDetalles) {
        // Buscar el producto por ID o lanzar una excepción si no existe
        ProductosModel producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar los detalles del producto con la información proporcionada
        producto.setCodigo_producto(productoDetalles.getCodigo_producto());
        producto.setNombre(productoDetalles.getNombre());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setPrecio_unitario(productoDetalles.getPrecio_unitario());
        producto.setCantidad_disponible(productoDetalles.getCantidad_disponible());
        producto.setEstado(productoDetalles.getEstado()); // Actualizar estado ('activo' o 'agotado')

        // Guardar los cambios en el repositorio
        return productoRepository.save(producto);
    }

    // Eliminar Producto

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}
