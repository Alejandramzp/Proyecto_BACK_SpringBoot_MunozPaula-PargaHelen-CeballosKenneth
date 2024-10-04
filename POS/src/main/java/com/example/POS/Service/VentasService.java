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

        // Obtener todas las ventas
        public List<VentasModel> getAllVentas() {
            return ventasRepository.findAll();
        }

        // Obtener una venta por ID
        public Optional<VentasModel> getVentaById(Long id) {
            return ventasRepository.findById(id);
        }

        // Guardar una nueva venta
        public VentasModel saveVenta(VentasModel ventasModel) {
            return ventasRepository.save(ventasModel);
        }

        // Actualizar una venta existente
        public VentasModel actualizarVenta(Long id, VentasModel detallesVenta) {
            // Buscar la venta por ID, o lanzar excepción si no existe
            VentasModel venta = ventasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

            // Actualizar los detalles de la venta
            venta.setNumero_venta(detallesVenta.getNumero_venta());
            venta.setFecha(detallesVenta.getFecha());
            venta.setTotal_venta(detallesVenta.getTotal_venta());
            venta.setEmpleado(detallesVenta.getEmpleado()); // Actualiza el empleado asociado a la venta
            venta.setEstado(detallesVenta.getEstado());

            // Guardar los cambios
            return ventasRepository.save(venta);
        }

        // Eliminar una venta por ID
        public void eliminarVenta(Long id) {
            ventasRepository.deleteById(id);
        }
    }

