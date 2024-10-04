package com.example.POS.Controller;


import com.example.POS.Model.VentasProductoModel;
import com.example.POS.Service.VentasProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class VentaProductoController {
    @Autowired
    private VentasProductoService ventasProductoService;

    // obtener todos las ventas por producto

    @GetMapping("/ventaProducto")

    public List<VentasProductoModel> getAllEmpleados(){
        return ventasProductoService.getAllVentasProducto();
    }

    @PostMapping("/ventaProducto")

    public VentasProductoModel saveVentaProducto (@RequestBody VentasProductoModel empleado){
        return ventasProductoService.saveVentasProducto(empleado);
    }

    @GetMapping ("/ventaProducto/{id}")
    public Optional<VentasProductoModel> getVentasProductoById(@PathVariable Long id){
        return ventasProductoService.getVentasProductoById(id);
    }

    @PutMapping("/ventaProducto/{id}")
    public VentasProductoModel actualizarVentasProducto (@PathVariable long id, @RequestBody VentasProductoModel ventaProducto) {
        return ventasProductoService.actualizarVentasProducto(id, ventaProducto);
    }

    @DeleteMapping("/ventaProducto/{id}")
    public void eliminareVentasProducto(@PathVariable long id){
        ventasProductoService.eliminarVentasProducto(id);



    }
}
