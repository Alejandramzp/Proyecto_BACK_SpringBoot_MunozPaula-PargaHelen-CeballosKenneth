package com.example.POS.Controller;

import com.example.POS.Model.UsuarioModel;
import com.example.POS.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // obtener todos los usuarios
    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        try {
            List<UsuarioModel> usuarios = usuarioService.getAllUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre alguna excepción
        }
    }

    // guardar un usuario
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel usuarioGuardado = usuarioService.saveUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener un usuario por ID
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<UsuarioModel>> getUsuarioById(@PathVariable Long id) {
        try {
            Optional<UsuarioModel> usuario = usuarioService.getUsuarioById(id);
            if (usuario.isPresent()) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el usuario
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un usuario
    @PutMapping("/usuario/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        try {
            UsuarioModel usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un usuario por ID
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}
