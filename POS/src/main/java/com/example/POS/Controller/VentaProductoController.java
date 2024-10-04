package com.example.POS.Controller;

import com.example.POS.Model.VentasProductoModel;
import com.example.POS.Service.VentasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VentaProductoController {

    @Autowired
    private VentasProductoService ventasProductoService;

    // obtener todas las ventas por producto
    @GetMapping("/ventaProducto")
    public ResponseEntity<List<VentasProductoModel>> getAllVentasProducto() {
        try {
            List<VentasProductoModel> ventasProductos = ventasProductoService.getAllVentasProducto();
            return ResponseEntity.ok(ventasProductos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre alguna excepción
        }
    }

    // guardar una venta por producto
    @PostMapping("/ventaProducto")
    public ResponseEntity<VentasProductoModel> saveVentaProducto(@RequestBody VentasProductoModel ventaProducto) {
        try {
            VentasProductoModel ventaGuardada = ventasProductoService.saveVentasProducto(ventaProducto);
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener una venta por producto por ID
    @GetMapping("/ventaProducto/{id}")
    public ResponseEntity<Optional<VentasProductoModel>> getVentasProductoById(@PathVariable Long id) {
        try {
            Optional<VentasProductoModel> ventaProducto = ventasProductoService.getVentasProductoById(id);
            if (ventaProducto.isPresent()) {
                return ResponseEntity.ok(ventaProducto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra la venta
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar una venta por producto
    @PutMapping("/ventaProducto/{id}")
    public ResponseEntity<VentasProductoModel> actualizarVentasProducto(@PathVariable Long id, @RequestBody VentasProductoModel ventaProducto) {
        try {
            VentasProductoModel ventaActualizada = ventasProductoService.actualizarVentasProducto(id, ventaProducto);
            return ResponseEntity.ok(ventaActualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar una venta por producto
    @DeleteMapping("/ventaProducto/{id}")
    public ResponseEntity<Void> eliminarVentasProducto(@PathVariable Long id) {
        try {
            ventasProductoService.eliminarVentasProducto(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}
