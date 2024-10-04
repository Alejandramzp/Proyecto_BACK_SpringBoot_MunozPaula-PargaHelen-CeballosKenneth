package com.example.POS.Controller;
import com.example.POS.Model.CarritoProductoModel;
import com.example.POS.Service.CarritoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")

public class CarritoProductoController {
    @Autowired
    private CarritoProductoService carritoProductoService;

    // obtener todos los productos

    @GetMapping("carritoProducto")
    public List<CarritoProductoModel> getAllCarritoProducto(){
        return carritoProductoService.getAllCarritoProducto();
    }

    @PostMapping("/carritoProducto")

    public CarritoProductoModel saveCarriroProducto (@RequestBody CarritoProductoModel carritoProducto){
        return carritoProductoService.saveCarritoProducto(carritoProducto);
    }

    @GetMapping ("/carritoProducto/{id}")
    public Optional<CarritoProductoModel> getProductoById(@PathVariable Long id){
        return carritoProductoService.getCarritoProductoById(id);
    }

    @PutMapping("/carritoProducto/{id}")
    public CarritoProductoModel actualizarCarritoProducto (@PathVariable long id, @RequestBody CarritoProductoModel carritoProducto) {
        return carritoProductoService.actualizarCarritoProducto(id, carritoProducto);
    }

    @DeleteMapping("/carritoProducto/{id}")
    public void eliminarempleado(@PathVariable long id){
        carritoProductoService.eliminarCarritoProducto(id);
    }
}
