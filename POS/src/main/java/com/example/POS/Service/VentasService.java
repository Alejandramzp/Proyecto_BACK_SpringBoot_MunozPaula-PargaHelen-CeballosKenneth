package com.example.POS.Service;

import com.example.POS.Model.VentasModel;
import com.example.POS.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    // Obtener todas
    public List<VentasModel> getAllVentas() {
        return ventasRepository.findAll();
    }

    // Obtener  por ID
    public Optional<VentasModel> getVentaById(Long id) {
        return ventasRepository.findById(id);
    }

    // Guardar
    public VentasModel saveVenta(VentasModel ventasModel) {
        return ventasRepository.save(ventasModel);
    }

    // Actualizar
    public VentasModel actualizarVenta(Long id, VentasModel detallesVenta) {
        VentasModel venta = ventasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        venta.setNumero_venta(detallesVenta.getNumero_venta());
        venta.setFecha(detallesVenta.getFecha());
        venta.setTotal_venta(detallesVenta.getTotal_venta());
        venta.setEmpleado(detallesVenta.getEmpleado());
        venta.setEstado(detallesVenta.getEstado());
        return ventasRepository.save(venta);
    }

    // Eliminar una venta por ID
    public void eliminarVenta(Long id) {
        ventasRepository.deleteById(id);
    }
}
