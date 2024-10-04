package com.example.POS.Controller;

import com.example.POS.Model.ProductosModel;
import com.example.POS.Model.RolModel;
import com.example.POS.Service.ProductoService;
import com.example.POS.Service.RolServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

RestController
@RequestMapping("/admin")

public class RolController {

        @Autowired
        private RolServicie rolService;

        // obtener todos los roles

        @GetMapping("rol")
        public List<RolModel> getAllRol(){
            return rolService.getAllRol();
        }

        @PostMapping("/rol")

        public RolModel saveRol (@RequestBody RolModel rol){
            return rolService.saveRol(rol);
        }

        @GetMapping ("/rol/{id}")
        public Optional<ProductosModel> getRolById(@PathVariable Long id){
            return rolService.getRolById(id);
        }

        @PutMapping("/producto/{id}")
        public ProductosModel actualizarProducto (@PathVariable long id, @RequestBody ProductosModel producto) {
            return rolService.actualizarRol(id, rol);
        }

        @DeleteMapping("/producto/{id}")
        public void eliminarProducto(@PathVariable long id){
            rolService.eliminarRol(id);
        }
    }

}
