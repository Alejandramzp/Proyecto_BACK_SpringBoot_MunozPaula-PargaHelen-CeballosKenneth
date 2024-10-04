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

    // Obtener todos
    public List<VentasProductoModel> getAllVentasProducto() {
        return ventasProductoRepository.findAll();
    }

    // Obtener por ID
    public Optional<VentasProductoModel> getVentasProductoById(Long id) {
        return ventasProductoRepository.findById(id);
    }

    // Guardar
    public VentasProductoModel saveVentasProducto(VentasProductoModel ventasProductoModel) {
        return ventasProductoRepository.save(ventasProductoModel);
    }

    // Actualizar
    public VentasProductoModel actualizarVentasProducto(Long id, VentasProductoModel detallesVentasProducto) {
        VentasProductoModel ventasProducto = ventasProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto de venta no encontrado"));

        ventasProducto.setCantidad(detallesVentasProducto.getCantidad());
        ventasProducto.setPrecio_unidad(detallesVentasProducto.getPrecio_unidad());
        ventasProducto.setProducto(detallesVentasProducto.getProducto());
        ventasProducto.setVenta(detallesVentasProducto.getVenta());

        return ventasProductoRepository.save(ventasProducto);
    }

    // Eliminar
    public void eliminarVentasProducto(Long id) {
        ventasProductoRepository.deleteById(id);
    }
}