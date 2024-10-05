package com.example.POS.Controller;

import com.example.POS.Model.ProductosModel;
import com.example.POS.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // obtener todos los productos
    @GetMapping("/producto")
    public ResponseEntity<List<ProductosModel>> getAllProducto() {
        try {
            List<ProductosModel> productos = productoService.getAllProducto();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre alguna excepción
        }
    }

    // guardar un producto
    @PostMapping("/producto")
    public ResponseEntity<ProductosModel> saveProducto(@RequestBody ProductosModel producto) {
        try {
            ProductosModel productoGuardado = productoService.saveProduto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener un producto por ID
    @GetMapping("/producto/{id}")
    public ResponseEntity<Optional<ProductosModel>> getProductoById(@PathVariable Long id) {
        try {
            Optional<ProductosModel> producto = productoService.getProductoById(id);
            if (producto.isPresent()) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el producto
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un producto
    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductosModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductosModel producto) {
        try {
            ProductosModel productoActualizado = productoService.actualizarProducto(id, producto);
            return ResponseEntity.ok(productoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un producto por ID
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}

