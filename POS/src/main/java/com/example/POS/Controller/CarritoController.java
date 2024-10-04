package com.example.POS.Controller;

import com.example.POS.Model.CarritoModel;
import com.example.POS.Service.CarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // obtener todos los carritos
    @GetMapping("/carrito")
    public ResponseEntity<List<CarritoModel>> getAllCarritos() {
        try {
            List<CarritoModel> carritos = carritoService.getAllCarritos();
            return ResponseEntity.ok(carritos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // Devuelve error 500 si ocurre alguna excepción
        }
    }

    // guardar un carrito
    @PostMapping("/carrito")
    public ResponseEntity<CarritoModel> saveCarrito(@RequestBody CarritoModel carrito) {
        try {
            CarritoModel carritoGuardado = carritoService.saveCarrito(carrito);
            return ResponseEntity.status(HttpStatus.CREATED).body(carritoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener un carrito por ID
    @GetMapping("/carrito/{id}")
    public ResponseEntity<Optional<CarritoModel>> getCarritoById(@PathVariable Long id) {
        try {
            Optional<CarritoModel> carrito = carritoService.getCarritoById(id);
            if (carrito.isPresent()) {
                return ResponseEntity.ok(carrito);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el carrito
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un carrito
    @PutMapping("/carrito/{id}")
    public ResponseEntity<CarritoModel> actualizarCarrito(@PathVariable Long id, @RequestBody CarritoModel carrito) {
        try {
            CarritoModel carritoActualizado = carritoService.actualizarCarrito(id, carrito);
            return ResponseEntity.ok(carritoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un carrito por ID
    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        try {
            carritoService.eliminarCarrito(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}

