package com.example.POS.Service;

import com.example.POS.Model.UsuarioModel;
import com.example.POS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel detallesUsuario) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre_usuario(detallesUsuario.getNombre_usuario()); // Actualizar nombre de usuario
        usuario.setPassword(detallesUsuario.getPassword()); // Actualizar contraseña
        usuario.setToken_jwt(detallesUsuario.getToken_jwt()); // Actualizar token JWT
        usuario.setEmpleado(detallesUsuario.getEmpleado()); // Actualizar empleado asociado
        usuario.setEstado(detallesUsuario.getEstado()); // Actualizar estado

        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
