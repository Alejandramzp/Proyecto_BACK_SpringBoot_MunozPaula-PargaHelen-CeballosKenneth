package com.example.POS.Controller;

import com.example.POS.Model.RolModel;
import com.example.POS.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolService rolService;

    // obtener todos los roles
    @GetMapping("/rol")
    public ResponseEntity<List<RolModel>> getAllRol() {
        try {
            List<RolModel> roles = rolService.getAllRol();
            return ResponseEntity.ok(roles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre alguna excepción
        }
    }

    // guardar un rol
    @PostMapping("/rol")
    public ResponseEntity<RolModel> saveRol(@RequestBody RolModel rol) {
        try {
            RolModel rolGuardado = rolService.saveRol(rol);
            return ResponseEntity.status(HttpStatus.CREATED).body(rolGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener un rol por ID
    @GetMapping("/rol/{id}")
    public ResponseEntity<Optional<RolModel>> getRolById(@PathVariable Long id) {
        try {
            Optional<RolModel> rol = rolService.getRolById(id);
            if (rol.isPresent()) {
                return ResponseEntity.ok(rol);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el rol
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un rol
    @PutMapping("/rol/{id}")
    public ResponseEntity<RolModel> actualizarRol(@PathVariable Long id, @RequestBody RolModel rol) {
        try {
            RolModel rolActualizado = rolService.actualizarRol(id, rol);
            return ResponseEntity.ok(rolActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un rol por ID
    @DeleteMapping("/rol/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        try {
            rolService.eliminarRol(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}
