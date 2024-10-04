package com.example.POS.Controller;


import com.example.POS.Model.VentasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class VentasController {
    @Autowired
    private VentasController ventasService;

    // obtener todos los productos

    @GetMapping("ventas")
    public List<VentasModel> getAllVenta(){
        return ventasService.getAllVenta();
    }

    @PostMapping("/ventas")

    public VentasModel saveVenta (@RequestBody VentasModel ventas){
        return ventasService.saveVenta(ventas);
    }

    @GetMapping ("/ventas/{id}")
    public Optional<VentasModel> getVentaById(@PathVariable Long id){
        return ventasService.getVentaById(id);
    }

    @PutMapping("/ventas/{id}")
    public VentasModel actualizarVenta(@PathVariable long id, @RequestBody VentasModel ventas) {
        return ventasService.actualizarVenta(id, ventas);
    }


}
