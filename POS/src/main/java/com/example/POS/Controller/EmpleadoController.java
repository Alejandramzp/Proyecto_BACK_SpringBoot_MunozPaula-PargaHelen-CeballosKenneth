package com.example.POS.Controller;

import com.example.POS.Model.EmpleadoModel;
import com.example.POS.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")

public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    // obtener todos los productos

    @GetMapping("empleado")
    public List<EmpleadoModel> getAllEmpleados(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping("/empleado")

    public EmpleadoModel saveEmpleado (@RequestBody EmpleadoModel empleado){
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping ("/empleado/{id}")
    public Optional<EmpleadoModel> getProductoById(@PathVariable Long id){
        return empleadoService.getEmpleadoById(id);
    }

    @PutMapping("/empleado/{id}")
    public EmpleadoModel actualizarProducto (@PathVariable long id, @RequestBody EmpleadoModel empleado) {
        return empleadoService.actualizarEmpleado(id, empleado);
    }

    @DeleteMapping("/empleado/{id}")
    public void eliminarempleado(@PathVariable long id){
        empleadoService.eliminarEmpleado(id);
    }
}
