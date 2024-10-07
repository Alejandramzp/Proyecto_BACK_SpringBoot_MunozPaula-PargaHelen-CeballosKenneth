package com.example.ColorPop.Controller;



import com.example.ColorPop.Model.Detalle_Venta;
import com.example.ColorPop.Service.Detalle_VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles_ventas")
public class Detalle_VentaController {
    @Autowired
    private Detalle_VentaService detalleVentaService;

    @GetMapping
    public List<Detalle_Venta> getAllDetallesVentas(){
        return detalleVentaService.getAllDetalleVenta();
    }

    @GetMapping("/{id}")
    public Detalle_Venta getDetalleVentaById(@PathVariable Long id){
        return detalleVentaService.getDetalleVentaById(id).orElseThrow();
    }

    @PostMapping
    public Detalle_Venta createDetallesVentas(@RequestBody Detalle_Venta detalleVenta){
        return detalleVentaService.saveDetalleVenta(detalleVenta);
    }

    @PutMapping("/{id}")
    public Detalle_Venta updateDetalleVenta(@PathVariable Long id, @RequestBody Detalle_Venta detalleVenta){
        return detalleVentaService.updateDetalleVenta(id, detalleVenta);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleVenta(@PathVariable Long id){
        detalleVentaService.deleteDetalleVenta(id);
    }
}
