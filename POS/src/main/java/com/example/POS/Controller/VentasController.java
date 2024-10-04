package com.example.POS.Controller;

import com.example.POS.Model.VentasModel;
import com.example.POS.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    // obtener todas las ventas
    @GetMapping("/ventas")
    public ResponseEntity<List<VentasModel>> getAllVentas() {
        try {
            List<VentasModel> ventas = ventasService.getAllVentas();
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // guardar una venta
    @PostMapping("/ventas")
    public ResponseEntity<VentasModel> saveVenta(@RequestBody VentasModel ventas) {
        try {
            VentasModel ventaGuardada = ventasService.saveVenta(ventas);
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener una venta por ID
    @GetMapping("/ventas/{id}")
    public ResponseEntity<Optional<VentasModel>> getVentaById(@PathVariable Long id) {
        try {
            Optional<VentasModel> venta = ventasService.getVentaById(id);
            if (venta.isPresent()) {
                return ResponseEntity.ok(venta);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra la venta
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar una venta por ID
    @PutMapping("/ventas/{id}")
    public ResponseEntity<VentasModel> actualizarVenta(@PathVariable Long id, @RequestBody VentasModel ventas) {
        try {
            VentasModel ventaActualizada = ventasService.actualizarVenta(id, ventas);
            return ResponseEntity.ok(ventaActualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar una venta por ID
    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        try {
            ventasService.eliminarVenta(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}
