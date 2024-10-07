package com.example.ColorPop.Controller;


import com.example.ColorPop.Model.Venta;
import com.example.ColorPop.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas(){
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id){
        return ventaService.getVentaById(id).orElseThrow();
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta){
        return ventaService.saveVenta(venta);
    }

    @PutMapping("/{id}")
    public Venta updateVenta(@PathVariable Long id, @RequestBody Venta venta){
        return ventaService.updateVenta(id, venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id){
        ventaService.deleteVenta(id);
    }
}
