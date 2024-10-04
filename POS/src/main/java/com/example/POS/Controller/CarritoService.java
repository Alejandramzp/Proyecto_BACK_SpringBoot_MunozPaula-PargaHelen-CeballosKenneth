package com.example.POS.Controller;

import com.example.POS.Model.CarritoModel;
import com.example.POS.Model.RolModel;
import com.example.POS.Service.RolServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class CarritoService {
    @Autowired
    private CarritoService carritoService;

    // obtener todos los roles

    @GetMapping("rol")
    public List<CarritoModel> getAllCarrito(){
        return carritoService.getAllCarrito();
    }

    @PostMapping("/carrito")

    public CarritoModel saveCarrito (@RequestBody CarritoModel carrito){
        return carritoService.saveCarrito(carrito);
    }

    @GetMapping ("/carrito/{id}")
    public Optional<CarritoModel> getCarritoById(@PathVariable Long id){
        return carritoService.getCarritoById(id);
    }

    @PutMapping("/carrito/{id}")
    public CarritoModel actualizarCarrito (@PathVariable long id, @RequestBody CarritoModel carrito) {
        return carritoService.actualizarCarrito(id, carrito);
    }

    @DeleteMapping("/carrito/{id}")
    public void eliminarCarrito(@PathVariable long id){
        carritoService.eliminarCarrito(id);
    }

}
