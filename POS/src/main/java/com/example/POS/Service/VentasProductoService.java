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
        // No es necesario mapear manualmente si ya estás usando VentasProductoModel
        return ventasProductoRepository.findAll();
    }

    // Obtener un producto de venta por ID
    public Optional<VentasProductoModel> getVentasProductoById(Long id) {
        return ventasProductoRepository.findById(id);
    }

    // Guardar un nuevo producto de venta
    public VentasProductoModel saveVentasProducto(VentasProductoModel ventasProductoModel) {
        // Guardar la entidad y devolver el modelo guardado
        return ventasProductoRepository.save(ventasProductoModel);
    }

    // Actualizar un producto de venta existente
    public VentasProductoModel actualizarVentasProducto(Long id, VentasProductoModel detallesVentasProducto) {
        VentasProductoModel ventasProducto = ventasProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto de venta no encontrado"));

        // Actualizar los valores de la entidad
        ventasProducto.setCantidad(detallesVentasProducto.getCantidad());
        ventasProducto.setPrecio_unidad(detallesVentasProducto.getPrecio_unidad());
        ventasProducto.setProducto(detallesVentasProducto.getProducto());
        ventasProducto.setVenta(detallesVentasProducto.getVenta());

        // Guardar la entidad actualizada
        return ventasProductoRepository.save(ventasProducto);
    }

    // Eliminar un producto de venta
    public void eliminarVentasProducto(Long id) {
        ventasProductoRepository.deleteById(id);
    }
}
