package com.example.POS.Controller;

import com.example.POS.Model.CarritoProductoModel;
import com.example.POS.Service.CarritoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarritoProductoController {
    @Autowired
    private CarritoProductoService carritoProductoService;

    // obtener todos los productos
    @GetMapping("/carritoProducto")
    public ResponseEntity<List<CarritoProductoModel>> getAllCarritoProducto() {
        try {
            List<CarritoProductoModel> productos = carritoProductoService.getAllCarritoProducto();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Devuelve un error 500 si ocurre alguna excepción
        }
    }

    // guardar un producto en el carrito
    @PostMapping("/carritoProducto")
    public ResponseEntity<CarritoProductoModel> saveCarritoProducto(@RequestBody CarritoProductoModel carritoProducto) {
        try {
            CarritoProductoModel productoGuardado = carritoProductoService.saveCarritoProducto(carritoProducto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si ocurre un problema en la solicitud
        }
    }

    // obtener un producto del carrito por ID
    @GetMapping("/carritoProducto/{id}")
    public ResponseEntity<Optional<CarritoProductoModel>> getProductoById(@PathVariable Long id) {
        try {
            Optional<CarritoProductoModel> producto = carritoProductoService.getCarritoProductoById(id);
            if (producto.isPresent()) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el producto
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un producto en el carrito
    @PutMapping("/carritoProducto/{id}")
    public ResponseEntity<CarritoProductoModel> actualizarCarritoProducto(@PathVariable Long id, @RequestBody CarritoProductoModel carritoProducto) {
        try {
            CarritoProductoModel productoActualizado = carritoProductoService.actualizarCarritoProducto(id, carritoProducto);
            return ResponseEntity.ok(productoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un producto del carrito por ID
    @DeleteMapping("/carritoProducto/{id}")
    public ResponseEntity<Void> eliminarCarritoProducto(@PathVariable Long id) {
        try {
            carritoProductoService.eliminarCarritoProducto(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}
