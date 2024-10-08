package com.example.ColorPop.Controller;

import com.example.ColorPop.Model.Usuario;
import com.example.ColorPop.Service.JwtService;
import com.example.ColorPop.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectar PasswordEncoder

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario loginRequest) {
        // Buscar el usuario por username
        Optional<Usuario> usuarioOpt = usuarioService.findByUsername(loginRequest.getUsername());

        // Validar usuario y contraseña
        if (usuarioOpt.isPresent() && usuarioOpt.get().getPassword().equals(loginRequest.getPassword())) {
            // Generar el token JWT
            String token = jwtService.generateToken(usuarioOpt.get().getUsername());

            // Crear un mapa para devolver el token
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response); // Devolver el token JWT
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Usuario o contraseña incorrectos"));
        }
    }


}