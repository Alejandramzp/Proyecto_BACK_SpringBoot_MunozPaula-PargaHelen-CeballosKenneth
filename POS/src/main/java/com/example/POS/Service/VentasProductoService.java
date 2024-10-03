package com.example.POS.Service;

import com.example.POS.Model.VentasProductoModel;
import com.example.POS.Repository.VentasProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasProductoService {

    @Autowired
    private VentasProductoRepository ventasProductoRepository;

    // Obtener todos los productos de ventas
    public List<VentasProductoModel> getAllVentasProducto() {
        return ventasProductoRepository.findAll();
    }


    // Obtener un producto de venta por ID
    public Optional<VentasProductoModel> getVentasProductoById(Long id) {
        return ventasProductoRepository.findById(id);
    }

    // Guardar un nuevo producto de venta
    public VentasProductoModel saveVentasProducto(VentasProductoModel ventasProducto) {
        return ventasProductoRepository.save(ventasProducto);
    }

    // Actualizar un producto de venta existente
    public VentasProductoModel actualizarVentasProducto(Long id, VentasProductoModel detallesVentasProducto) {
        VentasProductoModel ventasProducto = ventasProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto de venta no encontrado"));

        ventasProducto.setCantidad(detallesVentasProducto.getCantidad()); // Actualizar cantidad
        ventasProducto.setPrecio_unidad(detallesVentasProducto.getPrecio_unidad()); // Actualizar precio por unidad
        ventasProducto.setProducto(detallesVentasProducto.getProducto()); // Actualizar ID del producto
        ventasProducto.setVenta(detallesVentasProducto.getVenta()); // Actualizar ID de la venta

        return ventasProductoRepository.save(ventasProducto);
    }

    // Eliminar un producto de venta
    public void eliminarVentasProducto(Long id) {
        ventasProductoRepository.deleteById(id);
    }
}

