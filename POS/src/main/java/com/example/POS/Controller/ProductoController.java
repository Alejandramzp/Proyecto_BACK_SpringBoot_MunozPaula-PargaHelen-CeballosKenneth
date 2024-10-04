package com.example.POS.Controller;

import com.example.POS.Model.ProductosModel;
import com.example.POS.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/admin")

public class ProductoController {
    @Autowired
    private ProductoService productoService;

    // obtener todos los productos

    @GetMapping("producto")
    public List<ProductosModel> getAllProducto(){
        return productoService.getAllProducto();
    }

    @PostMapping ("/producto")

    public ProductosModel saveProducto (@RequestBody ProductosModel producto){
        return productoService.saveProduto(producto);
    }

    @GetMapping ("/producto/{id}")
    public Optional<ProductosModel>getProductoById(@PathVariable Long id){
        return productoService.getProductoById(id);
    }

    @PutMapping("/producto/{id}")
    public ProductosModel actualizarProducto (@PathVariable long id, @RequestBody ProductosModel producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/producto/{id}")
    public void eliminarProducto(@PathVariable long id){
        productoService.eliminarProducto(id);
    }
}
