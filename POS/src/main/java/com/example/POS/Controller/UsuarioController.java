package com.example.POS.Controller;


import com.example.POS.Model.UsuarioModel;
import com.example.POS.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // obtener todos los roles

    @GetMapping("usuario")
    public List<UsuarioModel> getAlusuario(){
        return  usuarioService.getAllUsuarios();
    }

    @PostMapping("/usuario")
    public UsuarioModel saveUsuario (@RequestBody UsuarioModel usuario){
        return  usuarioService.saveUsuario(usuario);
    }

    @GetMapping ("/usuario/{id}")
    public Optional<UsuarioModel> getRolById(@PathVariable Long id){
        return  usuarioService.getUsuarioById(id);
    }

    @PutMapping("/usuario/{id}")
    public UsuarioModel actualizarRol (@PathVariable long id, @RequestBody UsuarioModel usuario) {
        return  usuarioService.actualizarUsuario(id,usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void eliminarusuario(@PathVariable long id){
         usuarioService.eliminarUsuario(id);
    }

}
