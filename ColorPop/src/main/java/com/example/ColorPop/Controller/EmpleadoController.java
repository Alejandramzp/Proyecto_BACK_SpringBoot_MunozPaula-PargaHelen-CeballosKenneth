package com.example.ColorPop.Controller;


import com.example.ColorPop.Model.Empleado;
import com.example.ColorPop.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id){
        return empleadoService.getEmpleadoById(id).orElseThrow();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id){
        empleadoService.deleteEmpleado(id);
    }
}
