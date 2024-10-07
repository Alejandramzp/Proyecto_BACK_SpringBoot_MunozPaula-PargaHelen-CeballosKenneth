package com.example.ColorPop.Controller;



import com.example.ColorPop.Model.Detalle_Venta;
import com.example.ColorPop.Service.Detalle_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/detalles_ventas")
public class Detalle_VentaController {

    @Autowired
    private Detalle_VentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<Detalle_Venta>> getAllDetallesVentas() {
        try {
            List<Detalle_Venta> detallesVentas = detalleVentaService.getAllDetalleVenta();
            return ResponseEntity.ok(detallesVentas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_Venta> getDetalleVentaById(@PathVariable Long id) {
        try {
            Detalle_Venta detalleVenta = detalleVentaService.getDetalleVentaById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle de venta no encontrado"));
            return ResponseEntity.ok(detalleVenta);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Detalle_Venta> createDetalleVenta(@RequestBody Detalle_Venta detalleVenta) {
        try {
            Detalle_Venta nuevoDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalleVenta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_Venta> updateDetalleVenta(@PathVariable Long id, @RequestBody Detalle_Venta detalleVenta) {
        try {
            Detalle_Venta detalleVentaActualizado = detalleVentaService.updateDetalleVenta(id, detalleVenta);
            return ResponseEntity.ok(detalleVentaActualizado);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Long id) {
        try {
            detalleVentaService.deleteDetalleVenta(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

