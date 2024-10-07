package com.example.ColorPop.Controller;


import com.example.ColorPop.Model.Carrito;
import com.example.ColorPop.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarrito(){
        return carritoService.getAllCarritos();
    }

    @GetMapping("/{id}")
    public Carrito getCarritoById(@PathVariable Long id){
        return carritoService.getCarritoById(id).orElseThrow();
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito){
        return carritoService.saveCarrito(carrito);
    }

    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable Long id, @RequestBody Carrito carrito){
        return carritoService.updateCarrito(id, carrito);
    }

    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Long id){
        carritoService.deleteCarrito(id);
    }
}
