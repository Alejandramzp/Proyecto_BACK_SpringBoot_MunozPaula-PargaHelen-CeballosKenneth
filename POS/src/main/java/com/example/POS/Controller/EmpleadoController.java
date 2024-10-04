package com.example.POS.Controller;

import com.example.POS.Model.EmpleadoModel;
import com.example.POS.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // obtener todos los empleados
    @GetMapping("/empleado")
    public ResponseEntity<List<EmpleadoModel>> getAllEmpleados() {
        try {
            List<EmpleadoModel> empleados = empleadoService.getAllEmpleados();
            return ResponseEntity.ok(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Devuelve error 500 si ocurre alguna excepción
        }
    }

    // guardar un empleado
    @PostMapping("/empleado")
    public ResponseEntity<EmpleadoModel> saveEmpleado(@RequestBody EmpleadoModel empleado) {
        try {
            EmpleadoModel empleadoGuardado = empleadoService.saveEmpleado(empleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si hay problemas con la solicitud
        }
    }

    // obtener un empleado por ID
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Optional<EmpleadoModel>> getEmpleadoById(@PathVariable Long id) {
        try {
            Optional<EmpleadoModel> empleado = empleadoService.getEmpleadoById(id);
            if (empleado.isPresent()) {
                return ResponseEntity.ok(empleado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Error 404 si no se encuentra el empleado
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // actualizar un empleado
    @PutMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoModel> actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadoModel empleado) {
        try {
            EmpleadoModel empleadoActualizado = empleadoService.actualizarEmpleado(id, empleado);
            return ResponseEntity.ok(empleadoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Error 400 si los datos no son válidos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Error 500 si ocurre una excepción
        }
    }

    // eliminar un empleado por ID
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        try {
            empleadoService.eliminarEmpleado(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 si la eliminación es exitosa
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // Error 500 si ocurre una excepción
        }
    }
}

