package com.example.ColorPop.Controller;


import com.example.ColorPop.Model.Venta;
import com.example.ColorPop.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        try {
            List<Venta> ventas = ventaService.getAllVentas();
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        try {
            Venta venta = ventaService.getVentaById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada"));
            return ResponseEntity.ok(venta);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        try {
            Venta nuevaVenta = ventaService.saveVenta(venta);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        try {
            Venta ventaActualizada = ventaService.updateVenta(id, venta);
            return ResponseEntity.ok(ventaActualizada);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        try {
            ventaService.deleteVenta(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint para agregar productos a una venta y actualizar el total
    @PostMapping("/{ventaId}/agregarProducto/{productoId}")
    public ResponseEntity<Venta> agregarProductoADetalleVenta(
            @PathVariable Long ventaId,
            @PathVariable Long productoId,
            @RequestParam int cantidad) {
        try {
            Venta ventaActualizada = ventaService.agregarProductoADetalleVenta(ventaId, productoId, cantidad);
            return ResponseEntity.ok(ventaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
